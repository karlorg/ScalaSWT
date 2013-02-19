package de.mritter.swt.dsl.binding

import org.eclipse.core.databinding._
import org.eclipse.core.databinding.beans.BeanProperties
import org.eclipse.core.databinding.observable.value.IObservableValue
import org.eclipse.core.databinding.validation.{IValidator, ValidationStatus}
import org.eclipse.core.runtime.IStatus
import org.eclipse.jface.databinding.swt.WidgetProperties
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.{Control}

trait DataBindings {

	def onModify(obj: AnyRef, property: String)(target: Control)(implicit dbc: DataBindingContext) = {
		dbc.bindValue(
			WidgetProperties.text(SWT.Modify).observe(target),
			BeanProperties.value(property).observe(obj))
	}
}