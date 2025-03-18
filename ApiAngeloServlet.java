import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/angelo.json")
public class ApiAngeloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Substitua pelos seus dados
        String ra = "1290482322046";
        String nome = "Angelo Ferreira";
        String[] disciplinas = {"Sistemas Operacionais 2", "Programação Orientada a Objetos", "Banco de Dados 1", "Engenharia de Software 3", "Inglês 4", "Metodologia de Pesquisa", "Linguagem de Programação 4"};

        // Cria o objeto JSON
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"ra\":\"").append(ra).append("\",");
        json.append("\"nome\":\"").append(nome).append("\",");
        json.append("\"disciplinas\":[");
        for (int i = 0; i < disciplinas.length; i++) {
            json.append("\"").append(disciplinas[i]).append("\"");
            if (i < disciplinas.length - 1) {
                json.append(",");
            }
        }
        json.append("]}");

        out.print(json);
        out.flush();
        
    }

    private class Dados {
        String ra;
        String nome;
        String[] disciplinas;

        public Dados(String ra, String nome, String[] disciplinas) {
            this.ra = ra;
            this.nome = nome;
            this.disciplinas = disciplinas;
        }
    }
}