package de.mritter.swt.dsl.layout

import org.eclipse.swt.widgets.Control
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.SWT

trait GridCell {
	private case class FGridData(
								val align: Int => Unit,
								val grabExcessSpace: Boolean => Unit,
								val indent: Int => Unit,
								val span: Int => Unit)

	private def withLayoutData(f: (GridData) => Unit)(target: Control) = {
		val data = target.getLayoutData() match {
			case x: GridData => x
			case _ => new GridData()
		}
		f(data)
		target.setLayoutData(data)
	}

	def horizontal(settings: FGridData => Unit*) = withLayoutData { layoutData =>
		val gd = new FGridData(layoutData.horizontalAlignment=_,
								layoutData.grabExcessHorizontalSpace=_,
								layoutData.horizontalIndent=_,
								layoutData.horizontalSpan=_)
		settings.foreach(_(gd))
	}_

	def vertical(settings: FGridData => Unit*) = withLayoutData { layoutData =>
		val gd = new FGridData(layoutData.verticalAlignment=_,
								layoutData.grabExcessVerticalSpace=_,
								layoutData.verticalIndent=_,
								layoutData.verticalSpan=_)
		settings.foreach(_(gd))
	}_

	def beginning(gd: FGridData) = {
		gd.align(GridData.BEGINNING)
	}

	def center(gd: FGridData) = {
		gd.align(GridData.CENTER)
	}

	def end(gd: FGridData) = {
		gd.align(GridData.END)
	}

	def fill(gd: FGridData) = {
		gd.align(GridData.FILL)
	}

	def grabExcessSpace(gd: FGridData) = {
		gd.grabExcessSpace(true)
	}

	def span(cols: Int)(gd: FGridData) = {
		gd.span(cols)
	}

	def indent(pixels: Int)(gd: FGridData) = {
		gd.indent(pixels)
	}

	def minimumSize(width: Int, height: Int) = withLayoutData { layoutData =>
		layoutData.minimumWidth = width
		layoutData.minimumHeight = height
	}_

	def sizeHint(width: Int, height: Int) = withLayoutData { layoutData =>
		layoutData.widthHint = width
		layoutData.heightHint = height
	}_
}