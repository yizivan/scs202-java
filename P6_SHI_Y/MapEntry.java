package P6_SHI_Y;
//---------------------------------------------------------------------------
// MapEntry.java              by Dale/Joyce/Weems                   Chapter 8
//
// Provides key, value pairs for use with a Map.
// Keys are immutable.
//---------------------------------------------------------------------------

public class MapEntry<K, V> implements Comparable<MapEntry<K,V>>
{
  protected K key;
  protected V value;
  
  MapEntry(K k, V v)
  {
    key = k; value = v;
  }
  
  public K getKey()  {return key;}
  public V getValue(){return value;}
  public void setValue(V v){value = v;}

  @Override
  public String toString()
  // Returns a string representing this MapEntry.
  {
    return String.valueOf(key);
  }

  public int compareTo(MapEntry<K,V> secondDP) 
    {
        if (String.valueOf(value).compareTo(String.valueOf(secondDP.getValue())) < 0)
            return -1;
        if (String.valueOf(value).compareTo(String.valueOf(secondDP.getValue())) > 0)
            return 1;
        return 0;
    }
}
 