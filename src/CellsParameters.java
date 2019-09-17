public class CellsParameters {
    public double fieldCell;
    public String predecessor;
    public Object neighbourNorth;
    public Object neighbourEast;
    public Object neighbourSouth;
    public Object neighbourWest;



    public CellsParameters (double fieldCell, String predecessor) {
        this.fieldCell = fieldCell;
        this.predecessor = predecessor;
    }
    public void SetNeighboursN(Object neighbourNorth){
         this.neighbourNorth = neighbourNorth;
    }
    public void SetNeighboursE(Object neighbourEast){
        this.neighbourEast = neighbourEast;
    }
    public void SetNeighboursS(Object neighbourSouth){
        this.neighbourSouth = neighbourSouth;
    }
    public void SetNeighboursW(Object neighbourWest){
        this.neighbourWest = neighbourWest;
    }
}

