package de.mritter.swt.dsl.binding

import org.eclipse.swt.events._

trait Bindings extends DataBindings {

	def onClick(f: SelectionEvent => Unit)(target: {def addSelectionListener(listener: SelectionListener)}) = {
		target.addSelectionListener(new SelectionAdapter{
			def widgetSelected = f
		})
	}
}