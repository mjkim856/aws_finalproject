package websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class ChatWebSocketConfig implements WebSocketConfigurer {
	// ws 요청시 ChatWebSocketHandler mapping 한다.
	// ChatWebSocketHandler 요청이 오면 ws와 mapping 시켜줄게!
	// xxxConfigurer들이 이런 역할 하는 듯?
	private final WebSocketHandler handler;

	public ChatWebSocketConfig(WebSocketHandler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 		  "ws://localhost:8085/ws"
		registry.addHandler(handler, "/ws").setAllowedOrigins("*");
	}
	
}
