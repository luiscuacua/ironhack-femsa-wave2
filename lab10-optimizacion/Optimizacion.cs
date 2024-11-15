// Unnecessary computations in data processing

public List<int> ProcessData(List<int> data) {
    List<int> result = new List<int>();
    foreach (var d in data) {
        if (d % 2 == 0) {
            result.Add(d * 2);
        } else { // else innecesario este se puede eliminar, ya que si no entra en el if se ejecutara la linea result.Add(d * 3);
            result.Add(d * 3);
        }
    }
    return result;
}


//En lugar de iterar manualmente con un foreach, se puede utilizar LINQ con Select
//ejemplo
public List<int> ProcessData(List<int> data) {
    return data.Select(d => d % 2 == 0 ? d * 2 : d * 3).ToList();
}