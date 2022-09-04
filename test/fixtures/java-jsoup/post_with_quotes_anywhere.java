import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws IOException {

		byte[] message = ("ol':asd\"").getBytes("UTF-8");
		String basicAuth = DatatypeConverter.printBase64Binary(message);

		Connection.Response response = Jsoup.connect("http://localhost:28139/")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.requestBody("{\"a\":\"b\"}")
				.header("Authorization", "Basic " + basicAuth);
				.header("A", "''a'");
				.header("B", "\"")
				.cookie("x=1")
				.cookie("y=2")
				.method(Connection.Method.POST)
				.ignoreContentType(true)
				.timeout(30000)
				.execute();

		System.out.println(response.parse());
	}
}
