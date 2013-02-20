package de.mritter.swt.dsl.widgets

import org.eclipse.swt.widgets.{Control, List}
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.{Color, RGB}
import org.eclipse.jface.resource.{JFaceResources, LocalResourceManager}

trait WidgetProperties {

	def text[T <: {def setText(s: String)}](txt: => String)(target: T) = {
		target.setText(txt)
	}

	def title[T <: {def setText(s: String)}](txt: => String)(target: T) = {
		target.setText(txt)
	}

	def focus(target: Control) = {
		target.setFocus();
	}

	def toolTip(txt: String)(target: Control) = {
		target.setToolTipText(txt)
	}

	def minimum[T <: {def setMinimum(n: Int)}](min: => Int)(target: T) = {
		target.setMinimum(min)
	}

	def maximum[T <: {def setMaximum(n: Int)}](max: => Int)(target: T) = {
		target.setMaximum(max)
	}

	// Selecting

	def selected[T <: {def setSelection(b: Boolean)}](target:T) = {
		target.setSelection(true)
	}

	def selectedIndex[T <: {def setSelection(n: Int)}](index: => Int)(target: T) = {
		target.setSelection(index)
	}
	
	def selectedIndex(indices: => Array[Int])(target: List) = {
		target.setSelection(indices)
	}

	def selection[T <: {def setSelection(n: Int)}](selection: => Int)(target: T) = {
		target.setSelection(selection)
	}

	def selection(start: => Int, end: => Int)(target: List) = {
		target.setSelection(start, end)
	}


	def background(red: Int, green: Int, blue: Int)(target: Control) = {
		val resManager = new LocalResourceManager(JFaceResources.getResources(), target)
		val color = resManager.createColor(new RGB(red, green, blue))
		target.setBackground(color)
	}

	def foreground(red: Int, green: Int, blue: Int)(target: Control) = {
		val resManager = new LocalResourceManager(JFaceResources.getResources(), target)
		val color = resManager.createColor(new RGB(red, green, blue))
		target.setForeground(color)
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

	// Alignment

	def alignCenter[T <: {def setAlignment(a: Int)}](target: T) = {
		target.setAlignment(SWT.CENTER)
	}

	def alignLeft[T <: {def setAlignment(a: Int)}](target: T) = {
		target.setAlignment(SWT.LEFT)
	}

	def alignRight[T <: {def setAlignment(a: Int)}](target: T) = {
		target.setAlignment(SWT.RIGHT)
	}

	// Enabled

	def enabled[T <: {def setEnabled(b: Boolean)}](b: => Boolean)(target: T) = {
		target.setEnabled(b)
	}

	def enabled: Unit = enabled(true)_

	def disabled = enabled(false)_
}