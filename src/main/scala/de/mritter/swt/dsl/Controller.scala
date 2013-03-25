package de.mritter.swt.dsl

import org.eclipse.swt.widgets.Shell

class Controller(val shell: Shell) {
    def open() {
	    val display = shell.getDisplay
        
        shell.pack();
        shell.open();
        
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        
        display.dispose();
    }
}