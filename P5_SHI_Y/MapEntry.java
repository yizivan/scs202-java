package P5_SHI_Y;
public class MapEntry<K, V> implements Comparable<MapEntry<K, V>>
{
    protected K key;
    protected V value;
    
    public MapEntry(K k, V v)
    {
        key = k;
        value = v;
    }
    public K getKey()
    {
        return key;
    }
    public V getValue()
    {
        return value;
    }
    public void setVaule(V v)
    {
        value = v;
    }
    public String toString()
    {
        return key.toString();
    }
    public int compareTo(MapEntry<K,V> secondMapEntry) 
    {
        if (String.valueOf(value).compareTo(String.valueOf(secondMapEntry.getValue())) < 0)
            return -1;
        if (String.valueOf(value).compareTo(String.valueOf(secondMapEntry.getValue())) > 0)
            return 1;
        return 0;
    }
}