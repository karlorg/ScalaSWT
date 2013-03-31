package de.mritter.swt.dsl.widgets

import org.eclipse.swt.widgets._
import org.eclipse.swt.SWT

trait Widgets extends WidgetProperties {
	private def createWidget[T,P](factory: P => T)(setups: T => Unit*)(parent: P) = {
		val w = factory(parent)
		setups.foreach(_(w))
	}

	def button = createWidget(new Button(_:Composite, SWT.PUSH))_

	def checkbox = createWidget(new Button(_:Composite, SWT.CHECK))_

	def radio = createWidget(new Button(_:Composite, SWT.RADIO))_

	def canvas = createWidget(new Canvas(_:Composite, SWT.NONE))_
	
	def caret = createWidget(new Caret(_:Canvas, SWT.NONE))_
	
	def colorDialog = createWidget(new ColorDialog(_:Shell, SWT.NONE))_

	def combo = createWidget(new Combo(_:Composite, SWT.NONE))_

	def composite = createWidget(new Composite(_:Composite, SWT.NONE))_

	def coolBar = createWidget(new CoolBar(_:Composite, SWT.NONE))_

	def coolItem = createWidget(new CoolItem(_:CoolBar, SWT.NONE))_

	def dateTime = createWidget(new DateTime(_:Composite, SWT.NONE))_

	def decorations = createWidget(new Decorations(_:Composite, SWT.NONE))_

	def directoryDialog = createWidget(new DirectoryDialog(_:Shell, SWT.NONE))_

	def expandBar = createWidget(new ExpandBar(_:Composite, SWT.NONE))_

	def expandItem = createWidget(new ExpandItem(_:ExpandBar, SWT.NONE))_

	def fileDialog = createWidget(new FileDialog(_:Shell, SWT.NONE))_

	def fontDialog = createWidget(new FontDialog(_:Shell, SWT.NONE))_

	def group = createWidget(new Group(_:Composite, SWT.NONE))_

	// TODO: what is this intended to do? Item is abstract
	// def item = createWidget(new Item(_, SWT.NONE))_ // needs Widgelt

	def label = createWidget(new Label(_:Composite, SWT.NONE))_

	def link = createWidget(new Link(_:Composite, SWT.NONE))_

	def list = createWidget(new List(_:Composite, SWT.NONE))_
	
	// TODO: menu needs expanding into various functions to handle the many
	// types of menu
	
	// def menu = createWidget(new Menu(_, SWT.NONE))_ // needs Control, Decorations, Menu or MenuItem

	def menuItem = createWidget(new MenuItem(_:Menu, SWT.NONE))_

	def messageBox = createWidget(new MessageBox(_:Shell, SWT.NONE))_

	def progressBar = createWidget(new ProgressBar(_:Composite, SWT.NONE))_

	def sash = createWidget(new Sash(_:Composite, SWT.NONE))_

	def scale = createWidget(new Scale(_:Composite, SWT.NONE))_

	def slider = createWidget(new Slider(_:Composite, SWT.NONE))_

	def spinner = createWidget(new Spinner(_:Composite, SWT.BORDER))_

	// TODO: tab folders and items need their own logic; items are children of
	// folders, but the contents of tab items are also children of the folder,
	// not of the item they inhabit.
	
	// def tabFolder = createWidget(new TabFolder(_:Composite, SWT.NONE))_

	// def tabItem = createWidget(new TabItem(_:TabFolder, SWT.NONE))_

	def table = createWidget(new Table(_:Composite, SWT.BORDER))_

	def tableColumn = createWidget(new TableColumn(_:Table, SWT.NONE))_

	def tableItem = createWidget(new TableItem(_:Table, SWT.NONE))_



	def edit = createWidget(new Text(_:Composite, SWT.BORDER))_

	def editfield = createWidget(new Text(_:Composite, SWT.MULTI))_

	def password = createWidget(new Text(_:Composite, SWT.PASSWORD))_

	def readOnly(target: Text) = {
		target.setEditable(false)
	}

	def message(msg: String)(target: Text) = {
		target.setMessage(msg)
	}



	def toolBar = createWidget(new ToolBar(_:Composite, SWT.NONE))_

	def toolItem = createWidget(new ToolItem(_:ToolBar, SWT.NONE))_

	def toolTip = createWidget(new ToolTip(_:Shell, SWT.NONE))_

	def tracker = createWidget(new Tracker(_:Composite, SWT.NONE))_

	def trayItem = createWidget(new TrayItem(_:Tray, SWT.NONE))_

	def tree = createWidget(new Tree(_:Composite, SWT.NONE))_

	def treeColumn = createWidget(new TreeColumn(_:Tree, SWT.NONE))_

	// def treeItem = createWidget(new TreeItem(_, SWT.NONE))_ // needs Tree or TreeItem
}