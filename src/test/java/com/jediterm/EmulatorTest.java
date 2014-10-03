package com.jediterm;

import com.jediterm.terminal.display.BackBuffer;
import com.jediterm.terminal.emulator.ColorPalette;

import java.io.IOException;

/**
 * @author traff
 */
public class EmulatorTest extends EmulatorTestAbstract {
  public void testSetCursorPosition() throws IOException {
    doTest(3, 4, "X00\n" +  //X wins
                 "0X \n" +
                 "X X\n" +
                 "   \n");
  }

  //public void testTooLargeScrollRegion() throws IOException { TODO: this test fails on Travis somehow
  //  doTest(80, 24);
  //}

  public void testMidnightCommanderOnVT100() throws IOException {
    doTest();
  }

  public void testMidnightCommanderOnXTerm() throws IOException {
    BackBuffer backBuffer = doTest();

    assertColor(backBuffer.getStyleAt(8, 2), ColorPalette.getIndexedColor(3), ColorPalette.getIndexedColor(4));
    assertColor(backBuffer.getStyleAt(23, 4), ColorPalette.getIndexedColor(7), ColorPalette.getIndexedColor(4));
    assertColor(backBuffer.getStyleAt(2, 0), ColorPalette.getIndexedColor(0), ColorPalette.getIndexedColor(6));
  }

  @Override
  protected String getPathToTest() {
    return TestPathsManager.getTestDataPath() + getName();
  }
}
