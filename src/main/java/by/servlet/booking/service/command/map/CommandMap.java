package by.servlet.booking.service.command.map;

import java.util.Map;
import java.util.HashMap;

import by.servlet.booking.service.command.*;

public class CommandMap {
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public CommandMap() {
		initialize();
	}
	
	public void initialize() {
		commands.clear();
		commands.put("SIGN_UP_USER", new RegisterUserCommand());
		commands.put("SIGN_IN_USER", new AuthorizeUserCommand());
		commands.put("LOGOUT_USER", new LogoutUserCommand());
		commands.put("SHOW_ROOMS", new ShowRoomListCommand());
		commands.put("CANCEL_BOOKING", new CancelBookingCommand());
		commands.put("BOOK_ROOM_NOW", new BookRoomNowCommand());
		commands.put("SHOW_NOT_RESERVED_ROOMS", new ShowNotReservedRoomsCommand());
		// commands.put("GET_ALL_USERS", new GetAllUsersCommand());
	}
	
	public Command get(String key) {
		return commands.get(key);
	}
}
