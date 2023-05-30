package OO_Kueche;

public class FigurFactory {

    public enum FigurTyp{DREIECK, RECHTECK, KREIS};
    

    public Figur2d createFigur( FigurTyp typ ){
        Figur2d figur;

        switch ( typ) {
            case DREIECK:
                figur = new Dreieck(1000, "Dreieck" , 2, 2, 2);
                return figur;
            case RECHTECK:
                figur = new Rechteck(2000, "Rechteck", 3,4);
                return figur;
            case KREIS:
                figur = new Kreis(4000, "Kreis", 4);
                return figur;

        }
        return null;
    }


    public Figur3d create3D(String typ3D){
        
        Figur3d figur;

        switch(typ3D){
            case "GleichseitigePyramide" :            
            return figur = new GleichseitigePyramide(new Neck(200, "Neck", 2, 3), 2);
            
        }


        return null;


    }

}
