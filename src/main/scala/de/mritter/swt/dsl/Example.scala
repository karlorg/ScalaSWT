package de.mritter.swt.dsl

import de.mritter.swt.dsl.Swt._
import org.eclipse.swt.widgets._

object Example {
	
	def main(args : Array[String]) {
		var myShell: Shell = null
		var saveButton: Button = null

		shell(
			(myShell = _),
			title("User Profile"),
			composite(
				gridLayout(columns(2)),
				group(
					title("Name"),
					gridLayout(columns(2)),
					horizontalAndVertical(fill, grabExcessSpace),
					vertical(fill, grabExcessSpace),
					label(text("First")), edit(text("Bullet")),
					label(text("Last")), edit(text("Tooth"))
				),
				group(
					title("Gender"),
					columnLayout(),
					horizontalAndVertical(fill, grabExcessSpace),
					radio(text("Male"), selected),
					radio(text("Female")) 
				),
				group(
					title("Role"),
					columnLayout(),
					horizontalAndVertical(fill, grabExcessSpace),
					checkbox(text("Student"), selected),
					checkbox(text("Employee"), selected)  
				),
				group(
					title("Experience"),
					columnLayout(),
					horizontalAndVertical(fill, grabExcessSpace),
					spinner(selection(5), label(text("years")), modify( (event, source) => {
						saveButton.setEnabled(true)

						saveButton.setText("Save")

						// or ...
						text("Save")(saveButton)

						// or ...
						using(saveButton)(
							text("Save")
						)
					}))
				),
				button(
					(saveButton = _),
					title("Save"),
					horizontal(right, grabExcessSpace),
					vertical(center, grabExcessSpace),
					mouseUp((event, button) => {
						button.setEnabled(false)
						button.setText("Done")
					})
				),
				button(
					title("Close"),
					horizontal(left, grabExcessSpace),
					vertical(center, grabExcessSpace),
					click( (e, s) => {
						myShell.dispose
					})
				)
			)
		).open
	}
}