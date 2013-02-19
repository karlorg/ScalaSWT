package de.mritter.swt.dsl.layout

trait Margins {
	private trait MarginLike {
		var marginTop: Int
		var marginRight: Int
		var marginBottom: Int
		var marginLeft: Int
	}

	/**marginBottom specifies the number of pixels of vertical margin that will be placed along the bottom edge of the layout.
	*/
	def marginBottom[T <: MarginLike](pixels: Int)(target: T) = {
		target.marginBottom = pixels
	}

	/**marginLeft specifies the number of pixels of horizontal margin that will be placed along the left edge of the layout.
	*/
	def marginLeft[T <: MarginLike](pixels: Int)(target: T) = {
		target.marginLeft = pixels
	}

	/**marginRight specifies the number of pixels of horizontal margin that will be placed along the right edge of the layout.
	*/
	def marginRight[T <: MarginLike](pixels: Int)(target: T) = {
		target.marginRight = pixels
	}

	/**marginTop specifies the number of pixels of vertical margin that will be placed along the top edge of the layout.
	*/
	def marginTop[T <: MarginLike](pixels: Int)(target: T) = {
		target.marginTop = pixels
	}

	/**marginHeight specifies the number of pixels of vertical margin that will be placed along the top and bottom edges of the layout.
	*/
	def	marginHeight[T <: {var marginHeight: Int}](pixels: Int)(target: T) = {
		target.marginHeight = pixels
	}

	/**marginWidth specifies the number of pixels of horizontal margin that will be placed along the left and right edges of the layout.
	*/
	def	marginWidth[T <: {var marginWidth: Int}](pixels: Int)(target: T) = {
		target.marginWidth = pixels
	}
         
	def margin[T <: MarginLike](topBottom: Int, rightLeft: Int)(target: T) = {
		target.marginTop = topBottom
		target.marginRight = rightLeft
		target.marginBottom = topBottom
		target.marginLeft = rightLeft
	}

	def margin[T <: MarginLike](top: Int, rightLeft: Int, bottom: Int)(target: T) = {
		target.marginTop = top
		target.marginRight = rightLeft
		target.marginBottom = bottom
		target.marginLeft = rightLeft
	}

	def margin[T <: MarginLike](top: Int, right: Int, bottom: Int, left: Int)(target: T) = {
		target.marginTop = top
		target.marginRight = right
		target.marginBottom = bottom
		target.marginLeft = left
	}
}