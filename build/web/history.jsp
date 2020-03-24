<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Model.*"%>
<%!
    // --- String Join Function
    public String join(ArrayList<?> arr, String del)
    {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.size(); i++)
        {
            if (i > 0) output.append(del);
            
            // --- Quote strings, only, for JS syntax
            if (arr.get(i) instanceof String) output.append("\"");
            output.append(arr.get(i));
            if (arr.get(i) instanceof String) output.append("\"");
        }
        return output.toString();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Chart Demo</title>
    <script type="text/javascript" src="https://cdn.zingchart.com/zingchart.min.js"></script>
</head>
<body>
    <script>
        <%
            ArrayList<Student>store=(ArrayList<Student>)request.getAttribute("Marks");
            ArrayList<String> Name = new ArrayList<String>();
            ArrayList<Integer> Score = new ArrayList<Integer>();
            for(int i=0;i<store.size();i++)
            {
                Name.add(store.get(i).getName());
                Score.add(store.get(i).getScore());
            }
            System.out.println(Name);
            System.out.println(Score);
        %>
        var Name = [<%= join(Name, ",") %>];
        var Score = [<%= join(Score, ",") %>];
        
    </script>
    <script>
    window.onload = function()
    {
        zingchart.render
        ({
            id:"myChart",
            width:"100%",
            height:400,
            data:
            {
                "type":"line",
                "title":
                {
                    "text":"Data Pulled from Mongo Database"
                },
                "scale-x":
                {
                    "labels": Name
                },
                "plot":
                {
                    "line-width":1
                },
                "series":
                [
                    {
                      "values":Score
                    }
                ]
            }
        });
    };
    </script>
    <h1>Data from Mongo Database</h1>
    <h1>Score</h1>
    <div id="myChart"></div>
</body>
</html>