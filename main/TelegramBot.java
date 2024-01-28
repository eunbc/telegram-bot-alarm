package main;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

class TelegramBot {

	private static final String BOT_TOKEN = "bot-token";
	private static final String CHAT_ID = "숫자 아이디";
	private static final String BASE_URL = "https://api.telegram.org/bot";
	private static final String MESSAGE = "알람 메세지";

	public static void main(String[] args) {
		sendMessage(MESSAGE);
	}

	private static void sendMessage(String message) {
		String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
		String url = BASE_URL + BOT_TOKEN + "/sendMessage?chat_id=" + CHAT_ID + "&text=" + encodedMessage;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.GET()
			.build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response : "+ response.body());
		} catch (Exception e) {
			System.err.println("Message send failed : " + e);
		}
	}

}
