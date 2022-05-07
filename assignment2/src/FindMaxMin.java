
public class FindMaxMin {
    public int Max(int[] x){
        int Max=x[0];
        for(int i=0; i<x.length; i++){
            if(x[i]>Max){
            Max=x[i];
        }
        }
        return Max;
    }
        public int Min(int[] x){ int Min=x[0];
            for(int i=0; i<x.length; i++){ if(x[i]<Min){
                Min=x[i];
            }
            }
            return Min;
        }
    }
