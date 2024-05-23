package flapping_bat.GUI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.model.Position;

import java.io.IOException;


public class LanternaTextGUI {
    public static final int height = 35, width = 60;
    private final Screen screen;
    public LanternaTextGUI() throws IOException {

        Terminal terminal = createTerminal();
        this.screen = createScreen(terminal);
    }
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal() throws IOException {
        TerminalSize terminalSize = new TerminalSize(width,height+1);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        return defaultTerminalFactory.createTerminal();
    }

    public KeyStroke getNextAction() throws IOException {
        return screen.pollInput();
    }
    public void drawText(Position position, String text, String color, String backgroundColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setBackgroundColor(TextColor.Factory.fromString(backgroundColor));
        tg.putString(position.getX(), position.getY(), text,SGR.BOLD);
    }
    public void paintBackground(String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height + 1), ' ');
    }
    public void drawRectangle(Position position, int width, int height, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.drawRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(width, height), ' ');
    }

    public void drawPixel(Position position, char c, String color, String backgroundColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setBackgroundColor(TextColor.Factory.fromString(backgroundColor));
        tg.putString(position.getX(), position.getY(), "" + c,SGR.BOLD);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void drawOption(Position position, String text, String Color) {

    }
    public void drawTitle(Position position, String text) {

    }
    public void paintPixel(Position position, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), " ");
    }

    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }
    public void close() throws IOException {
        screen.close();
    }
}
