package tppitweaks.client.gui.modGuides;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import tppitweaks.client.gui.library.gui.GuiBase;
import tppitweaks.client.gui.library.gui.button.GuideButton;
import tppitweaks.client.gui.library.gui.element.ElementBase;
import tppitweaks.client.gui.library.gui.element.ElementScrollBar;
import tppitweaks.client.gui.library.gui.element.ElementScrollPanel;
import tppitweaks.client.gui.library.gui.element.ElementText;
import codechicken.nei.VisiblityData;

public class GuiGuideBase extends GuiBase
{
	protected Map<String, GuiMod> mods;
	
	protected String title, body;
	
	protected static final int LENGTH = 140;
	
	public GuiGuideBase()
	{
		super(new ResourceLocation("tppitweaks", "textures/gui/guiGuide.png"));
		drawInventory = false;
		this.xSize = 256;
		this.ySize = 178;
		
		title = "Main menu";
		body = "This is a test. This is a test. This is a test. This is a test. ";
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		initButtons();
		initPanel();
	}
	
	protected void initPanel()
	{
		System.out.println("init panel");
		
		ElementScrollPanel panel = new ElementScrollPanel(this, this.xSize / 6, this.ySize / 9, this.xSize, (int) (this.ySize / 1.35));
		List<String> lines = getLines();
		
		for (int i = 0; i < lines.size(); i++)
		{
			panel.addElement(new ElementText(this, 0, (i * 10), lines.get(i), null, 0x282828, false));
		}		
		
		ArrayList<ElementBase> elementsNew = new ArrayList<ElementBase>();
		
		for (ElementBase e : elements)
		{
			if (!(e instanceof ElementScrollBar || e instanceof ElementScrollPanel))
				elementsNew.add(e);
		}
		
		this.elements = elementsNew;
		
		this.addElement(panel);
		this.addElement(new ElementScrollBar(this, 217, 15, 6, 139, panel));
	}
	
	private List<String> getLines()
	{
		List<String> lines = new ArrayList<String>();
		lines.add(title);
		lines.add("");
		FontRenderer render = this.mc.fontRenderer;
		String[] words = body.split(" ");
		String currentLine = "";
		for (String s : words)
		{
			currentLine += s + " ";
			if (render.getStringWidth(currentLine) > this.xSize - (this.xSize - LENGTH))
			{
				lines.add(currentLine);
				currentLine = "";
			}
		}
		lines.add(currentLine);
		return lines;
	}
	
	@Override
	public VisiblityData modifyVisiblity(GuiContainer gui, VisiblityData currentVisibility)
	{
		currentVisibility.showNEI = false;
		return currentVisibility;
	}
	
	private void initButtons()
	{
		this.addElement(new GuideButton(this, 0, 2, 10));
		this.addElement(new GuideButton(this, 1, 2, 40));
		this.addElement(new GuideButton(this, 2, 2, 70));
		this.addElement(new GuideButton(this, 3, 2, 100));
		this.addElement(new GuideButton(this, 4, 228, 10));
		this.addElement(new GuideButton(this, 5, 228, 40));
		this.addElement(new GuideButton(this, 6, 228, 70));
		this.addElement(new GuideButton(this, 7, 228, 100));
	}

	@Override
	public boolean hideItemPanelSlot(GuiContainer gui, int x, int y, int w, int h)
	{
		return true;
	}
	
	public void modifyGui(int buttonID)
	{
		this.body = "This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. This is a test. ";
		this.initPanel();
	}
}
