package mapeamentoareasverdesjoinville;

public class Localizacao
{
    private final int idAreaVerde;
    private final double latitude;
    private final int latitudeNorteSul;
    private final double longitude;
    private final int longitudeNorteSul;
    private int idLocalizacao;


    public int getIdAreaVerde() {return idAreaVerde;}
    public void setIdLocalizacao(int idLocalizacao) {this.idLocalizacao = idLocalizacao;}

    public Localizacao (int idAreaVerde, double latitude, int latitudeNorteSul, double longitude, int longitudeNorteSul)
    {
        this.idAreaVerde = idAreaVerde;
        this.latitude = latitude;
        this.latitudeNorteSul = latitudeNorteSul;
        this.longitude = longitude;
        this.longitudeNorteSul = longitudeNorteSul;
    }

    @Override
    public String toString()
    {
        String direcaoLatitude = (latitudeNorteSul == 1) ? "(Norte)" : "(Sul)";
        String direcaoLongitude = (longitudeNorteSul == 1) ? "(Leste)" : "(Oeste)";

        return  "Latitude: " + latitude + "° " + direcaoLatitude + "\n" +
                "Longitude: " + longitude + "° " + direcaoLongitude+ "\n";
    }



}



