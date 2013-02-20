package de.mritter.swt.dsl.binding

import org.eclipse.swt.events._

trait Bindings extends DataBindings {

	def click[T <: {def addSelectionListener(lst: SelectionListener)}](f: (SelectionEvent, T) => Unit)(target: T) = {
		target.addSelectionListener(new SelectionAdapter{
			override def widgetSelected(event: SelectionEvent) = f(event, target)
		})
	}

	def modify[T <: {def addModifyListener(lst: ModifyListener)}](f: (ModifyEvent, T) => Unit)(target: T) = {
		target.addModifyListener(new ModifyListener {
			override def modifyText(event: ModifyEvent) = f(event, target)
		})
	}

	def doubleClick[T <: {def addMouseListener(lst: MouseListener)}](f: (MouseEvent, T) => Unit)(target: T) = {
		target.addMouseListener(new MouseAdapter {
	 		override def mouseDoubleClick(event: MouseEvent) = f(event, target)
		})
	}

	def mouseDown[T <: {def addMouseListener(lst: MouseListener)}](f: (MouseEvent, T) => Unit)(target: T) = {
	 	target.addMouseListener(new MouseAdapter {
	 		override def mouseDown(event: MouseEvent) = f(event, target)
	 	})
	 }

	def mouseUp[T <: {def addMouseListener(lst: MouseListener)}](f: (MouseEvent, T) => Unit)(target: T) = {
	 	target.addMouseListener(new MouseAdapter {
	 		override def mouseUp(event: MouseEvent) = f(event, target)
	 	})
	}
}