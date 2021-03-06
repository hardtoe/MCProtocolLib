package ch.spacebase.mc.protocol.packet.ingame.server;

import java.io.IOException;

import ch.spacebase.mc.util.message.Message;
import ch.spacebase.packetlib.io.NetInput;
import ch.spacebase.packetlib.io.NetOutput;
import ch.spacebase.packetlib.packet.Packet;

public class ServerChatPacket implements Packet {
	
	private Message message;
	
	public ServerChatPacket() {
	}
	
	public ServerChatPacket(String message) {
		this(new Message(message));
	}
	
	public ServerChatPacket(Message message) {
		this.message = message;
	}
	
	public String getRawMessage() {
		return this.message.getRawText();
	}
	
	public Message getMessage() {
		return this.message;
	}

	@Override
	public void read(NetInput in) throws IOException {
		this.message = new Message(in.readString(), true);
	}

	@Override
	public void write(NetOutput out) throws IOException {
		out.writeString(this.message.toString());
	}
	
	@Override
	public boolean isPriority() {
		return false;
	}

}
