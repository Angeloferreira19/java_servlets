import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loteria.json")
public class loteriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
        String dataHora = dateFormat.format(new Date());
        int[] numeros = gerarNumerosLoteria();

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"dataHora\":\"").append(dataHora).append("\",");
        json.append("\"numeros\":").append(Arrays.toString(numeros));
        json.append("}");

        out.print(json);
        out.flush();
    }

    private int[] gerarNumerosLoteria() {
        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();
        while (numeros.size() < 6) {
            numeros.add(random.nextInt(60) + 1); // Números de 1 a 60
        }
        return numeros.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private class Loteria {
        String dataHora;
        int[] numeros;

        public Loteria(String dataHora, int[] numeros) {
            this.dataHora = dataHora;
            this.numeros = numeros;
        }
    }
}