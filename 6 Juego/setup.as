package  {
	
	import flash.display.MovieClip;
	
	
	public class setup extends MovieClip {
		private var fondo_new: fondo=new fondo();
		private var piso_new: piso=new piso();
		private var prota_new: prota=new prota();
		public function setup() {
			// constructor code
			addChild (fondo_new);
			addChild (piso_new);
			addChild (prota_new);
			//Medidas:y=550, x=400
			
			fondo_new.y=200;
			fondo_new.x=275;
			
			piso_new.y=400;
			piso_new.x=0;
			
			prota_new.y=350;
			prota_new.x=200;
		}
	}
}