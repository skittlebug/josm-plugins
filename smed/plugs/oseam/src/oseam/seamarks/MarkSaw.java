package oseam.seamarks;

import java.util.Map;

import javax.swing.ImageIcon;

import oseam.dialogs.OSeaMAction;
import oseam.seamarks.SeaMark;

public class MarkSaw extends SeaMark {
	public MarkSaw(OSeaMAction dia) {
		super(dia);
	}

	public void parseMark() {

		String str;
		Map<String, String> keys;
		keys = dlg.node.getKeys();

		if (!dlg.panelMain.chanButton.isSelected())
			dlg.panelMain.chanButton.doClick();
		if (!dlg.panelMain.panelChan.safeWaterButton.isSelected())
			dlg.panelMain.panelChan.safeWaterButton.doClick();

		if (keys.containsKey("name"))
			setName(keys.get("name"));

		if (keys.containsKey("seamark:name"))
			setName(keys.get("seamark:name"));

		if (keys.containsKey("seamark:buoy_safe_water:name"))
			setName(keys.get("seamark:buoy_safe_water:name"));
		else if (keys.containsKey("seamark:beacon_safe_water:name"))
			setName(keys.get("seamark:beacon_safe_water:name"));
		else if (keys.containsKey("seamark:light_float:name"))
			setName(keys.get("seamark:light_float:name"));

		if (keys.containsKey("seamark:buoy_safe_water:shape")) {
			str = keys.get("seamark:buoy_safe_water:shape");

			if (str.equals("pillar"))
				dlg.panelMain.panelChan.panelSaw.pillarButton.doClick();
			else if (str.equals("spar"))
				dlg.panelMain.panelChan.panelSaw.sparButton.doClick();
			else if (str.equals("sphere"))
				dlg.panelMain.panelChan.panelSaw.sphereButton.doClick();
			else if (str.equals("barrel"))
				dlg.panelMain.panelChan.panelSaw.barrelButton.doClick();
		} else if ((keys.containsKey("seamark:type")) && (keys.get("seamark:type").equals("light_float"))) {
			dlg.panelMain.panelChan.panelSaw.floatButton.doClick();
		}

		super.parseMark();
	}

	public void paintSign() {

		String image = "/images/Safe_Water";

		switch (getShape()) {
		case PILLAR:
			image += "_Pillar";
			break;
		case SPAR:
			image += "_Spar";
			break;
		case SPHERE:
			image += "_Sphere";
			break;
		case BEACON:
			image += "_Beacon";
			break;
		case FLOAT:
			image += "_Float";
			break;
		default:
			dlg.panelMain.shapeIcon.setIcon(null);
			return;
		}
			image += ".png";
			dlg.panelMain.shapeIcon.setIcon(new ImageIcon(getClass().getResource(image)));

			super.paintSign();
	}
}