package de.mritter.swt.dsl.layout

import org.eclipse.swt.widgets.{Composite, Control, Layout}
import org.eclipse.swt.layout._
import org.eclipse.swt.SWT

trait Layouts extends Margins with GridCell {

	private def createLayout[T <: Layout](layout: T)(setups: T => Unit*)(parent: Composite) = {
		parent.setLayout(layout)
		setups.foreach(_(layout))
	}


	// FillLayout

	def fillLayout = createLayout(new FillLayout())_

	def vertical(fl: FillLayout) = {
		fl.`type` = SWT.VERTICAL
	}

	def horizontal(fl: FillLayout) = {
		fl.`type` = SWT.HORIZONTAL
	}


	// FormLayout

	def formLayout = createLayout(new FormLayout())_


	// GridLayout

	def gridLayout = createLayout(new GridLayout())_

	/**numColumns specifies the number of cell columns in the layout.
	*/
	def columns(n: Int)(gl: GridLayout) = {
		gl.numColumns = n
	}

	/**makeColumnsEqualWidth specifies whether all columns in the layout will be forced to have the same width. default is false.
	*/
	def columnsEqualWidth(gl: GridLayout) = {
		gl.makeColumnsEqualWidth = true
	}


	// RowLayout
	
	def columnLayout = createLayout(new RowLayout(SWT.HORIZONTAL))_

	def rowLayout = createLayout(new RowLayout(SWT.VERTICAL))_

	/**center specifies whether the controls in a row should be centered vertically in each cell for horizontal layouts, or centered horizontally in each cell for vertical layouts. The default value is false.
	*/
	def center(rl: RowLayout) = {
		rl.center = true
	}

	/**fill specifies whether the controls in a row should be all the same height for horizontal layouts, or the same width for vertical layouts. The default value is false.
	*/
	def fill(rl: RowLayout) = {
		rl.fill = true
	}
	
	/**justify specifies whether the controls in a row should be fully justified, with any extra space placed between the controls. The default value is false.
	*/
	def justify(rl: RowLayout) = {
		rl.justify = true
	}

	/**pack specifies whether all controls in the layout take their preferred size. The default value is true.
	*/
	def pack(rl: RowLayout) = {
		rl.pack = true
	}

	/**pack specifies whether all controls in the layout take their preferred size. The default value is true.
	*/
	def nopack(rl: RowLayout) = {
		rl.pack = false
	}

	/**wrap specifies whether a control will be wrapped to the next row if there is insufficient space on the current row. The default value is true.
	*/
	def wrap(rl: RowLayout) = {
		rl.wrap = true
	}

	/**wrap specifies whether a control will be wrapped to the next row if there is insufficient space on the current row. The default value is true.
	*/
	def nowrap(rl: RowLayout) = {
		rl.wrap = false
	}




	/**spacing specifies the number of pixels between the edge of one cell and the edge of its neighbouring cell.
	*/
	def spacing[T <: {var spacing: Int}](pixels: Int)(fl: T) = {
		fl.spacing = pixels
	}

	/**horizontalSpacing specifies the number of pixels between the right edge of one cell and the left edge of its neighbouring cell to the right.
	*/
	def horizontalSpacing[T <: {var horizontalSpacing: Int}](pixels: Int)(target: T) = {
		target.horizontalSpacing = pixels
	}

	/**verticalSpacing specifies the number of pixels between the bottom edge of one cell and the top edge of its neighbouring cell underneath.
	*/
	def verticalSpacing[T <: {var verticalSpacing: Int}](pixels: Int)(target: T) = {
		target.verticalSpacing = pixels
	}
}

