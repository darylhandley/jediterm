package com.jediterm.terminal.emulator.mouse;

import java.awt.event.MouseEvent;

/**
 * @author traff
 */
public interface TerminalMouseListener {
  void mousePressed(int x, int y, MouseEvent event);
  void mouseReleased(int x, int y, MouseEvent event);
}
