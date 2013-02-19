package de.mritter.swt.dsl.widgets

import org.eclipse.swt.widgets.{Control, List}
import org.eclipse.swt.SWT

trait WidgetProperties {

	def text[T <: {def setText(s: String)}](txt: => String)(target: T) = {
		target.setText(txt)
	}

	def title[T <: {def setText(s: String)}](txt: => String)(target: T) = {
		target.setText(txt)
	}


	// Selecting

	def selected[T <: {def setSelection(b: Boolean)}](target:T) = {
		target.setSelection(true)
	}

	def selectedIndex[T <: {def setSelection(i: Int)}](index: => Int)(target: T) {
		target.setSelection(index)
	}
	
	def selectedIndex(indices: => Array[Int])(target: List) {
		target.setSelection(indices)
	}

	def selection(start: => Int, end: => Int)(target: List) = {
		target.setSelection(start, end)
	}




	def focus(target: Control) = {
		target.setFocus();
	}

	def toolTip(txt: String)(target: Control) = {
		target.setToolTipText(txt)
	}

	// Visibility

	def visible(visible: => Boolean)(target: Control) = {
		target.setVisible(visible)
	}

	def visible: Unit = visible(true)_

	def invisible = visible(false)_

	// Orientation

	def center(target: Control) = {
		target.setOrientation(SWT.CENTER)
	}

	def left(target: Control) = {
		target.setOrientation(SWT.LEFT)
	}

	def right(target: Control) = {
		target.setOrientation(SWT.RIGHT)
	}

	// Enabled

	def enabled[T <: {def setEnabled(b: Boolean)}](b: => Boolean)(target: T) = {
		target.setEnabled(b)
	}

	def enabled: Unit = enabled(true)_

	def disabled = enabled(false)_
}