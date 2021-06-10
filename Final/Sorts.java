public class Sorts
{
    private String[] qsortInput;
    private String[] mergeInput;
    public String[] selectedSort(String[] stringArr)
    {
        String[] input = stringArr;
        for (int i = 0; i < input.length - 1; i++) 
        {
            int minIndex = i; 
            for (int j = i + 1; j < input.length; j++) 
            {
                if (input[j].compareTo(input[minIndex]) < 0) 
                {
                    minIndex = j; 
                }
            }
            if (i != minIndex) 
            {
                String temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
        return input;
    }

    public String[] bubbleSort(String[] stringArr)
    {
        String[] input = stringArr;
        for (int i = 0; i < input.length; i++)
        {
            for (int j = 0; j < input.length - i - 1; j++)
            {
                if (input[j].compareTo(input[j+1]) > 0)
                {
                    String temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }

    public String[] shortBubbleSort(String[] stringArr)
    {
        String[] input = stringArr;
        for (int i = 0; i < input.length; i++)
        {
            boolean flag = false;
            for (int j = 0; j < input.length - i - 1; j++)
            {
                if (input[j].compareTo(input[j+1]) > 0)
                {
                    String temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return input;
    }

    public String[] insertionSort(String[] stringArr)
    {
        String[] input = stringArr;
        for (int i = 1; i < input.length; i++)
        {
            String tmd = input[i];
            int index = i-1;
            while (index >= 0 && (tmd.compareTo(input[index]) < 0))
            {
                input[index + 1] = input[index];
                index --;
            }
            input[index +1] = tmd;
        }
        return input;
    }

    public void quicksort(int left, int right) 
    {
        int i, j;
        String t,temp;
        if(left > right)
            return;
        temp = qsortInput[left]; 
        i = left;
        j = right;
        while(i != j) 
        { 
            while(qsortInput[j].compareTo(temp) >=0 && i < j)
                j--;
            while(qsortInput[j].compareTo(temp) <=0 && i < j)
                i++;       
            if(i < j)
            {
                t = qsortInput[i];
                qsortInput[i] = qsortInput[j];
                qsortInput[j] = t;
            }
        }
        qsortInput[left] = qsortInput[i];
        qsortInput[i] = temp;
        quicksort(left, i-1);
        quicksort(i+1, right);
    }

    public String[] quickSort(String[] stringArr)
    {
        qsortInput = stringArr;
        quicksort(0, qsortInput.length-1);
        return qsortInput;
    }

    public void merge(String[] stringArr,int l,int m,int r)
    {
        String[] tmp = new String[r-l+1];
        int i,j,k;
        for(i=l;i<=r;i++){
            tmp[i-l]=stringArr[i];
        }
        for(i=l,j=m+1,k=l;k<=r;k++)
        {
            if(i>m)
            {
                stringArr[k]=tmp[j-l];
                j++;
            }
            else if(j>r)
            {
                stringArr[k]=tmp[i-l];
                i++;
            }
            else if(tmp[i-l].compareTo(tmp[j-l]) > 0)
            {
                stringArr[k]=tmp[j-l];
                j++;
            }
            else
            {
                stringArr[k]=tmp[i-l];
                i++;
            }
        }
    }
    public void mergesort(String[] stringArr,int left,int right)
    {
        int mid=(left+right)/2;
        if(right!=left)
        {
            mergesort(stringArr,left,mid);
            mergesort(stringArr,mid+1,right);
            if(stringArr[mid].compareTo(stringArr[mid+1]) > 0)
            {
                merge(stringArr,left,mid,right);
            }
        }
    }
    public String[] mergeSort(String[] stringArr)
    {
        mergeInput = stringArr;
        mergesort(mergeInput, 0, mergeInput.length-1);
        return mergeInput;
    }

}