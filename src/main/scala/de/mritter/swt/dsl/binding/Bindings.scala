package de.mritter.swt.dsl.binding

import org.eclipse.swt.widgets._
import org.eclipse.swt.events._

trait Bindings extends DataBindings {

	def onClick[T <: {def addSelectionListener(lst: SelectionListener)}](f: (SelectionEvent, T) => Unit)(target: T) = {
		target.addSelectionListener(new SelectionAdapter{
			override def widgetSelected(event: SelectionEvent) = f(event, target)
		})
	}

	def onModify[T <: {def addModifyListener(lst: ModifyListener)}](f: (ModifyEvent, T) => Unit)(target: T) = {
		target.addModifyListener(new ModifyListener {
			override def modifyText(event: ModifyEvent) = f(event, target)
		})
	}

	def onVerify[T <: {def addVerifyListener(lst: VerifyListener)}](f: (VerifyEvent, T) => Unit)(target: T) = {
		target.addVerifyListener(new VerifyListener {
			override def verifyText(event: VerifyEvent) = f(event, target)
		})
	}


	// Widget

	def onDispose[T <: Widget](f: (DisposeEvent, T) => Unit)(target: T) = {
		target.addDisposeListener(new DisposeListener {
			override def widgetDisposed(event: DisposeEvent) = f(event, target)
		})
	}


	// Control

	def onDoubleClick[T <: Control](f: (MouseEvent, T) => Unit)(target: T) = {
		target.addMouseListener(new MouseAdapter {
	 		override def mouseDoubleClick(event: MouseEvent) = f(event, target)
		})
	}

	def onMouseDown[T <: Control](f: (MouseEvent, T) => Unit)(target: T) = {
	 	target.addMouseListener(new MouseAdapter {
	 		override def mouseDown(event: MouseEvent) = f(event, target)
	 	})
	 }

	def onMouseUp[T <: Control](f: (MouseEvent, T) => Unit)(target: T) = {
	 	target.addMouseListener(new MouseAdapter {
	 		override def mouseUp(event: MouseEvent) = f(event, target)
	 	})
	}

	def onFocus[T <: Control](f: (FocusEvent, T) => Unit)(target: T) = {
	 	target.addFocusListener(new FocusAdapter {
	 		override def focusGained(event: FocusEvent) = f(event, target)
	 	})
	}

	def onFocusLost[T <: Control](f: (FocusEvent, T) => Unit)(target: T) = {
	 	target.addFocusListener(new FocusAdapter {
	 		override def focusLost(event: FocusEvent) = f(event, target)
	 	})
	}

// 	void	addControlListener(ControlListener listener) 
//           Adds the listener to the collection of listeners who will be notified when the control is moved or resized, by sending it one of the messages defined in the ControlListener interface.
//  void	addDragDetectListener(DragDetectListener listener) 
//           Adds the listener to the collection of listeners who will be notified when a drag gesture occurs, by sending it one of the messages defined in the DragDetectListener interface.
//  void	addFocusListener(FocusListener listener) 
//           Adds the listener to the collection of listeners who will be notified when the control gains or loses focus, by sending it one of the messages defined in the FocusListener interface.
//  void	addGestureListener(GestureListener listener) 
//           Adds the listener to the collection of listeners who will be notified when gesture events are generated for the control, by sending it one of the messages defined in the GestureListener interface.
//  void	addHelpListener(HelpListener listener) 
//           Adds the listener to the collection of listeners who will be notified when help events are generated for the control, by sending it one of the messages defined in the HelpListener interface.
//  void	addKeyListener(KeyListener listener) 
//           Adds the listener to the collection of listeners who will be notified when keys are pressed and released on the system keyboard, by sending it one of the messages defined in the KeyListener interface.
//  void	addMenuDetectListener(MenuDetectListener listener) 
//           Adds the listener to the collection of listeners who will be notified when the platform-specific context menu trigger has occurred, by sending it one of the messages defined in the MenuDetectListener interface.
//  void	addMouseListener(MouseListener listener) 
//           Adds the listener to the collection of listeners who will be notified when mouse buttons are pressed and released, by sending it one of the messages defined in the MouseListener interface.
//  void	addMouseMoveListener(MouseMoveListener listener) 
//           Adds the listener to the collection of listeners who will be notified when the mouse moves, by sending it one of the messages defined in the MouseMoveListener interface.
//  void	addMouseTrackListener(MouseTrackListener listener) 
//           Adds the listener to the collection of listeners who will be notified when the mouse passes or hovers over controls, by sending it one of the messages defined in the MouseTrackListener interface.
//  void	addMouseWheelListener(MouseWheelListener listener) 
//           Adds the listener to the collection of listeners who will be notified when the mouse wheel is scrolled, by sending it one of the messages defined in the MouseWheelListener interface.
//  void	addPaintListener(PaintListener listener) 
//           Adds the listener to the collection of listeners who will be notified when the receiver needs to be painted, by sending it one of the messages defined in the PaintListener interface.
//  void	addTouchListener(TouchListener listener) 
//           Adds the listener to the collection of listeners who will be notified when touch events occur, by sending it one of the messages defined in the TouchListener interface.
//  void	addTraverseListener(TraverseListener listener) 
//           Adds the listener to the collection of listeners who will be notified when traversal events occur, by sending it one of the messages defined in the TraverseListener interface.



}