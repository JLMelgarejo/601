package  {
	
	import flash.display.MovieClip;
	import flash.events.Event;
	
	
	public class setup extends MovieClip {
		private var fondo_new: fondo=new fondo();
		private var piso_new: piso=new piso();
		static var protagonista_new: protagonista=new protagonista();
		private var antagonista_new: antagonista=new antagonista ();
		static var puntos: Number=0;
		static var puntos_box_new: puntos_box=new puntos_box();
		public function setup() {
			// constructor code
			addChild (fondo_new);
			addChild (piso_new);
			addChild (protagonista_new);
			addChild (antagonista_new);
			addChild (puntos_box_new);
			//Medidas:y=550, x=400
			
			fondo_new.y=200;
			fondo_new.x=275;
			
			piso_new.y=365;
			piso_new.x=0;
			
			protagonista_new.y=350;
			protagonista_new.x=200;
			
			antagonista_new.y=50;
			antagonista_new.x=200;
			
			puntos_box_new.x=40;
			puntos_box_new.y=10;
			puntos_box_new.puntostxt.text=String(puntos);
			
			this.addEventListener(Event.ENTER_FRAME, actualiza_puntos);
		}
		public function actualiza_puntos(e:Event){
			puntos_box_new.puntostxt.text=String(puntos);
			}
	}
}