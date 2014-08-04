package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;
import org.freyja.libgdx.cocostudio.ui.widget.AdvancedImageButton;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabelStyle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;

public class CCButton extends GroupParser {

	@Override
	public String getClassName() {
		return "Button";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		ImageButtonStyle style = new ImageButtonStyle(null, null, null,
				editor.findDrawable(option, option.getNormalData().getPath()),
				editor.findDrawable(option, option.getPressedData().getPath()),
				null);
		Gdx.app.log("按钮资源up", option.getNormalData().getPath());
		Gdx.app.log("按钮资源down", option.getPressedData().getPath());
		
		style.imageDisabled = editor.findDrawable(option, option
				.getDisabledData().getPath());
		AdvancedImageButton button = new AdvancedImageButton(style);

		if (option.getText() != null && !option.getText().equals("")) {
			TTFLabelStyle labelStyle = editor.createLabelStyle(option);

			button.addText(option.getText(), labelStyle);
			button.setLabelColor(new Color(option.getTextColorR() / 255.0f, option
					.getTextColorG() / 255.0f, option.getTextColorB() / 255.0f, 1));
		}
		return button;
	}

}
