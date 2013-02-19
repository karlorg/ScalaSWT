package de.mritter.swt.dsl.widgets

import org.eclipse.swt.widgets._
import org.eclipse.swt.SWT

trait Widgets extends WidgetProperties {
	private def createWidget[T](factory: Composite => T)(setups: T => Unit*)(parent: Composite) = {
		val w = factory(parent)
		setups.foreach(_(w))
	}

	def button = createWidget(new Button(_, SWT.NONE))_

	def canvas = createWidget(new Canvas(_, SWT.NONE))_

	// def caret = createWidget(new Caret(_, SWT.NONE))_ // needs Canvas

	// def colorDialog = createWidget(new ColorDialog(_, SWT.NONE))_ // needs Shell

	def combo = createWidget(new Combo(_, SWT.NONE))_

	// def composite(setups: Composite => Unit*) = createWidget(new Composite(_, SWT.NONE))(setups: _*)_
	def composite = createWidget(new Composite(_, SWT.NONE))_

	def coolBar = createWidget(new CoolBar(_, SWT.NONE))_

	// def coolItem = createWidget(new CoolItem(_, SWT.NONE))_ // needs CoolBar

	def dateTime = createWidget(new DateTime(_, SWT.NONE))_

	def decorations = createWidget(new Decorations(_, SWT.NONE))_

	// def directoryDialog = createWidget(new DirectoryDialog(_, SWT.NONE))_ // needs Shell

	def expandBar = createWidget(new ExpandBar(_, SWT.NONE))_

	// def expandItem = createWidget(new ExpandItem(_, SWT.NONE))_ // needs ExpandBar

	// def fileDialog = createWidget(new FileDialog(_, SWT.NONE))_ // needs Shell

	// def fontDialog = createWidget(new FontDialog(_, SWT.NONE))_ // needs Shell

	def group = createWidget(new Group(_, SWT.NONE))_

	// def item = createWidget(new Item(_, SWT.NONE))_ // needs Widgelt

	def label = createWidget(new Label(_, SWT.NONE))_

	def link = createWidget(new Link(_, SWT.NONE))_

	def list = createWidget(new List(_, SWT.NONE))_

	// def menu = createWidget(new Menu(_, SWT.NONE))_ // needs Control, Decorations, Menu or MenuItem 

	// def menuItem = createWidget(new MenuItem(_, SWT.NONE))_ // needs Menu

	// def messageBox = createWidget(new MessageBox(_, SWT.NONE))_ // needs Shell

	def progressBar = createWidget(new ProgressBar(_, SWT.NONE))_

	def sash = createWidget(new Sash(_, SWT.NONE))_

	def scale = createWidget(new Scale(_, SWT.NONE))_

	def slider = createWidget(new Slider(_, SWT.NONE))_

	def spinner = createWidget(new Spinner(_, SWT.NONE))_

	def tabFolder = createWidget(new TabFolder(_, SWT.NONE))_

	// def tabItem = createWidget(new TabItem(_, SWT.NONE))_ // needs TabFolder

	def table = createWidget(new Table(_, SWT.NONE))_

	// def tableColumn = createWidget(new TableColumn(_, SWT.NONE))_ // needs Table

	// def tableItem = createWidget(new TableItem(_, SWT.NONE))_ // needs Table



	def edit = createWidget(new Text(_, SWT.NONE))_

	def editfield = createWidget(new Text(_, SWT.MULTI))_

	def password = createWidget(new Text(_, SWT.PASSWORD))_

	def readOnly(target: Text) = {
		target.setEditable(false)
	}

	def message(msg: String)(target: Text) = {
		target.setMessage(msg)
	}



	def toolBar = createWidget(new ToolBar(_, SWT.NONE))_

	// def toolItem = createWidget(new ToolItem(_, SWT.NONE))_ // needs ToolBar

	// def toolTip = createWidget(new ToolTip(_, SWT.NONE))_ // needs Shell

	def tracker = createWidget(new Tracker(_, SWT.NONE))_

	// def trayItem = createWidget(new TrayItem(_, SWT.NONE))_ // needs Tray

	def tree = createWidget(new Tree(_, SWT.NONE))_

	// def treeColumn = createWidget(new TreeColumn(_, SWT.NONE))_

	// def treeItem = createWidget(new TreeItem(_, SWT.NONE))_ // needs Tree or TreeItem
}