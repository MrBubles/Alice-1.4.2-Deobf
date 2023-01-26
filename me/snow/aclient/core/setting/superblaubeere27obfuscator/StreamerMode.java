

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.potion.PotionEffect
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TextUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.PotionEffect;

public class StreamerMode
        extends Module {
    public Setting<Integer> Field2989 = this.Method2150366(new Setting<Integer>("Width", 600, 100, 3160));
    public Setting<Integer> Field2990 = this.Method2150366(new Setting<Integer>("Height", 900, 100, 2140));
    private IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field2991;

    public StreamerMode() {
        super("StreamerMode", "Displays client info in a second window.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, false, false, false);
    }

    @Override
    public void Method2150372() {
        EventQueue.invokeLater(this::Method2150735);
    }

    @Override
    public void Method2150373() {
        if (this.Field2991 != null) {
            this.Field2991.setVisible(false);
        }
        this.Field2991 = null;
    }

    @Override
    public void Method2150378() {
        if (this.Field2991 != null) {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("Alice - 1.4.2");
            arrayList.add("");
            arrayList.add("No Connection.");
            this.Field2991.Method2150734(arrayList);
        }
    }

    @Override
    public void Method2150382() {
        this.Method2150380();
    }

    @Override
    public void Method2150375() {
        this.Method2150380();
    }

    @Override
    public void Method2150379() {
        if (this.Field2991 != null) {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("Alice - 1.4.2");
            arrayList.add("");
            arrayList.add("Fps: " + Minecraft.debugFPS);
            arrayList.add("TPS: " + AliceMain.Field768.Method2150203());
            arrayList.add("Ping: " + AliceMain.Field768.Method2150206() + "ms");
            arrayList.add("Speed: " + AliceMain.Field757.Method2150314() + "km/h");
            arrayList.add("Time: " + new SimpleDateFormat("h:mm a").format(new Date()));
            boolean bl = StreamerMode.Field2811.world.getBiome(StreamerMode.Field2811.player.getPosition()).getBiomeName().equals("Hell");
            int n2 = (int) StreamerMode.Field2811.player.posX;
            int n3 = (int) StreamerMode.Field2811.player.posY;
            int n4 = (int) StreamerMode.Field2811.player.posZ;
            float f = !bl ? 0.125f : 8.0f;
            int n5 = (int) (StreamerMode.Field2811.player.posX * (double) f);
            int n6 = (int) (StreamerMode.Field2811.player.posZ * (double) f);
            String string = "XYZ " + n2 + ", " + n3 + ", " + n4 + " [" + n5 + ", " + n6 + "]";
            String string2 = AliceMain.Field760.Method2150280(false);
            arrayList.add("");
            arrayList.add(string2);
            arrayList.add(string);
            arrayList.add("");
            for (Module object2 : AliceMain.Field756.Field3970) {
                String string3 = TextUtil.Method2164746(object2.Method2150303());
                arrayList.add(string3);
            }
            arrayList.add("");
            for (PotionEffect potionEffect : AliceMain.Field769.Method2150265()) {
                String string4 = TextUtil.Method2164746(AliceMain.Field769.Method2150260(potionEffect));
                arrayList.add(string4);
            }
            arrayList.add("");
            Map<String, Integer> map = EntityUtil.Method2163560();
            if (!map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    String string5 = TextUtil.Method2164746((String) entry.getKey());
                    arrayList.add(string5);
                }
            }
            this.Field2991.Method2150734(arrayList);
        }
    }

    private void Method2150735() {
        if (this.Field2991 == null) {
            this.Field2991 = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(this);
        }
        this.Field2991.setVisible(true);
    }

    public class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
            extends JFrame {
        final StreamerMode Field1117;
        private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field1116;

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(StreamerMode streamerMode) {
            this.Field1117 = streamerMode;
            this.Method2150733();
        }

        private void Method2150733() {
            this.Field1116 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this.Field1117);
            this.add(this.Field1116);
            this.setResizable(true);
            this.pack();
            this.setTitle("Alice - Info");
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(2);
        }

        public void Method2150734(ArrayList<String> arrayList) {
            this.Field1116.Method2150729(arrayList);
        }
    }

    public class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends JPanel {
        final StreamerMode Field2147;
        private final int Field2143;
        private final int Field2144;
        private Font Field2145;
        private ArrayList<String> Field2146;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(StreamerMode streamerMode) {
            this.Field2147 = streamerMode;
            this.Field2143 = streamerMode.Field2989.getValue();
            this.Field2144 = streamerMode.Field2990.getValue();
            this.Field2145 = new Font("Verdana", 0, 20);
            this.Field2146 = new ArrayList();
            this.Method2150731();
        }

        public void Method2150729(ArrayList<String> arrayList) {
            this.Field2146 = arrayList;
            this.repaint();
        }

        @Override
        public void setFont(Font font) {
            this.Field2145 = font;
        }

        public void Method2150720(int n2, int n3) {
            this.setPreferredSize(new Dimension(n2, n3));
        }

        private void Method2150731() {
            this.setBackground(Color.black);
            this.setFocusable(true);
            this.setPreferredSize(new Dimension(this.Field2143, this.Field2144));
        }

        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            this.Method2150732(graphics);
        }

        private void Method2150732(Graphics graphics) {
            Font font = this.Field2145;
            FontMetrics fontMetrics = this.getFontMetrics(font);
            graphics.setColor(Color.white);
            graphics.setFont(font);
            int n2 = 40;
            for (String string : this.Field2146) {
                graphics.drawString(string, (this.getWidth() - fontMetrics.stringWidth(string)) / 2, n2);
                n2 += 20;
            }
            Toolkit.getDefaultToolkit().sync();
        }
    }
}

