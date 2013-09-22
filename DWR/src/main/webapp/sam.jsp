<head>  
<script type='text/javascript' src='/DWR/dwr/interface/person.js'></script>
<script>
var pathToDwrServlet = "/DWR/dwr"; 
</script>

  <script type='text/javascript' src='/DWR/dwr/engine.js'></script>
 <script type='text/javascript' src='/DWR/dwr/util.js'></script>
<script>
dwr.engine.setActiveReverseAjax(true);
function clickme(){
person.sendStocks();
}
</script>
</head>
<div>
hello <input type="button" value="click me" onClick="clickme();">

<div id="elementID"></div>
</div>