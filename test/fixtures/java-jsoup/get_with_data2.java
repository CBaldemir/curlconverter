import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws IOException {

		Connection.Response response = Jsoup.connect("http://localhost:28139/v2/alerts_policy_channels.json?policy_id=policy_id&channel_ids=channel_id")
				.header("X-Api-Key", "{admin_api_key}")
				.header("Content-Type", "application/json")
				.method(Connection.Method.PUT)
				.ignoreContentType(true)
				.timeout(30000)
				.execute();

		System.out.println(response.parse());
	}
}
