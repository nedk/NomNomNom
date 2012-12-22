package com.ruoyiwang.chi.view;

import com.ruoyiwang.chi.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * This view is kind of a flowLayout, a tag/label wall
 * @author esong
 *
 */
public class ChiTagView extends LinearLayout {
	private int iParentWidth;
	private int curWidth;
	private LinearLayout curLine;
	private static LayoutInflater lif;
	
	public ChiTagView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		iParentWidth = context.getResources().getDisplayMetrics().widthPixels;
		
		lif = LayoutInflater.from(context);
		
		createNewLine();
	}
	
	public void setTag(View tag){
		tag.measure(0, 0);
		curWidth += tag.getMeasuredWidth();
		
		if(curWidth > iParentWidth - 10){
			this.addView(curLine);
			createNewLine();
			curWidth += tag.getMeasuredWidth(); // curWidth was setted to 0 in createNewLine
		}
		
		curLine.addView(tag);
	}
	
	private void createNewLine(){
		curLine = (LinearLayout) lif.inflate(R.layout.chi_tag_layout, null);
		curWidth = 0;
	}

}
