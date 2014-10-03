package veloterm.ui;

import com.jediterm.terminal.ui.settings.DefaultSettingsProvider;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-24
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class VeloTermSettingsProvider extends DefaultSettingsProvider {

    @Override
    public float getTerminalFontSize() {
        return 11;
    }


//    @Override
//    public ColorPalette getTerminalColorPalette() {
//        ColorPalette myPallete = new ColorPalette() {
//            @Override
//            public Color[] getIndexColors() {
//                return new Color[]{
//                        new Color(0x000000), //Black
//                        new Color(0xcd0000), //Red
//                        new Color(-3330768), //Green
//                        new Color(0xcdcd00), //Yellow
//                        new Color(0x1e90ff), //Blue
//                        new Color(0xcd00cd), //Magenta
//                        new Color(0x00cdcd), //Cyan
//                        new Color(-13551899), //White
//                        //Bright versions of the ISO colors
//                        new Color(0x4c4c4c), //Black
//                        new Color(0xff0000), //Red
//                        new Color(0x00ff00), //Green
//                        new Color(0xffff00), //Yellow
//                        new Color(0x4682b4), //Blue
//                        new Color(0xff00ff), //Magenta
//                        new Color(0x00ffff), //Cyan
//                        new Color(0x272822), //White
//                };
//            }
//        };
//
//        return myPallete;
//    }

}
