public class CellsParameters {
    public double fieldCell;
    public String predecessor;
    public CellsParameters neighbourNorth;
    public CellsParameters neighbourEast;
    public CellsParameters neighbourSouth;
    public CellsParameters neighbourWest;
    public String bestVariantCrop;



    public CellsParameters (double fieldCell, String predecessor) {
        this.fieldCell = fieldCell;
        this.predecessor = predecessor;
    }
    public void SetNeighboursN(CellsParameters neighbourNorth){
         this.neighbourNorth = neighbourNorth;
    }
    public void SetNeighboursE(CellsParameters neighbourEast){

        this.neighbourEast = neighbourEast;
    }
    public void SetNeighboursS(CellsParameters neighbourSouth){

        this.neighbourSouth = neighbourSouth;
    }
    public void SetNeighboursW(CellsParameters neighbourWest){

        this.neighbourWest = neighbourWest;
    }

    public void SetBestVariantCrop (String bestVariantCrop){

        this.bestVariantCrop = bestVariantCrop;
    }
}

