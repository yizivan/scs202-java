package P5_SHI_Y;
import java.util.ArrayList;
import java.util.Iterator;
public class ArrayListMap<K, V>
{
    protected ArrayList<MapEntry<K,V>> map;
    public ArrayListMap()
    {
        map = new ArrayList<MapEntry<K,V>>();
    }
    public V put(K k, V v)
    {
        if (k == null)
        {
            throw new IllegalArgumentException("Maps do not allow null keys.");
        }
        MapEntry<K, V> entry = new MapEntry<K, V>(k, v);
        MapEntry<K,V> temp;
        Iterator<MapEntry<K,V>> search = map.iterator();
        while (search.hasNext())
        {
            temp = search.next();
            if (temp.getKey().equals(k))
            {
                search.remove();
                map.add(entry);
                return temp.getValue();
            }
        }
        map.add(entry);
        return null;
    }
    public V get(K k)
    {
        if (k == null)
        {
            throw new IllegalArgumentException("Maps do not allow null keys.");
        }
        for (MapEntry<K,V> temp: map)
        {
            if (temp.getKey().equals(k))
            {
                return temp.getValue();
            } 
        }
        return null;
    }
    public V remove(K k)
    {
        if (k == null)
        {
            throw new IllegalArgumentException("Maps do not allow null keys.");
        }
        MapEntry<K,V> temp;
        Iterator<MapEntry<K,V>> search = map.iterator();
        while (search.hasNext())
        {
            temp = search.next();
            if (temp.getKey().equals(k))
            {
                search.remove();
                return temp.getValue();
            }
        }
        return null;
    }
    public boolean isEmpty()
    {
        return (map.size() == 0);
    }
}