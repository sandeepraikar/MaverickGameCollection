function Pager(tableName, itemsPerPage) {
    this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;
    this.pagerName = '';
    this.positionId = '';
    this.showRecords = function(from, to) {        
        var rows = document.getElementById(tableName).rows;
        // i starts from 1 to skip table header row
        for (var i = 1; i < rows.length; i++) {
            if (i < from || i > to)  
                rows[i].style.display = 'none';
            else
                rows[i].style.display = '';
        }
    };
    
    this.showPage = function(pageNumber) {
       if (! this.inited) {
              alert("not inited");
              return;
       }
       this.showPageNav(this.pagerName, this.positionId, pageNumber);
        
       var oldPageAnchor;
       if(document.getElementById('pg'+this.currentPage) != null){
    	   oldPageAnchor = document.getElementById('pg'+this.currentPage).parentNode;
    	   oldPageAnchor.className = 'normal';
       }
       
        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg'+this.currentPage).parentNode;
        newPageAnchor.className = 'active';
        
        var disablefirst = document.getElementById('pgfirst').parentNode;
        var disableprev = document.getElementById('pgprev').parentNode;
        var disablenext = document.getElementById('pgnext').parentNode;
        var disablelast = document.getElementById('pglast').parentNode;
        
        disablefirst.className = 'normal';
        disableprev.className = 'normal';
        disablenext.className = 'normal';
        disablelast.className = 'normal';
        
        if (pageNumber == 1)
        {
        	disablefirst.className = 'disabled';  
            disableprev.className = 'disabled';
            
        }
        if (this.pages == 1)
        {
        	disablefirst.className = 'disabled';  
            disableprev.className = 'disabled';
            disablenext.className = 'disabled';
            disablelast.className = 'disabled';
            
        }
        if(pageNumber == this.pages)
        {
            disablenext.className = 'disabled';
            disablelast.className = 'disabled';  
        }

        
        var from = (pageNumber - 1) * itemsPerPage + 1;
        var to = from + itemsPerPage - 1;
        this.showRecords(from, to);
    };   
    
    this.first = function() {
        if (this.currentPage > 1) {
        	this.showPageNav(this.pagerName, this.positionId, 1);
        	this.showPage(1);
        }
            
    };
    
    this.prev = function() {
        if (this.currentPage > 1) {
        	this.showPageNav(this.pagerName, this.positionId, this.currentPage - 1);
        	this.showPage(this.currentPage - 1);
        }
            
    };
    
    this.next = function() {
        if (this.currentPage < this.pages) {
        	this.showPageNav(this.pagerName, this.positionId, this.currentPage + 1);
            this.showPage(this.currentPage + 1);
        }
    };                       
    
    this.last = function() {
        if (this.currentPage < this.pages) {
        	this.showPageNav(this.pagerName, this.positionId, this.pages);
            this.showPage(this.pages);
        }
    };  
    
    this.init = function() {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length - 1); 
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
    };

    this.showPageNav = function(pagerName, positionId, pageNumber) {
       if (! this.inited) {
              alert("not inited");
              return;
       }
       this.pagerName = pagerName;
       this.positionId = positionId;
       var element = document.getElementById(positionId); 
       
       var endpg = this.pages;
       var startpg = 1;
       
       if(startpg == pageNumber) {
    	   startpg = pageNumber;    
       } else if (pageNumber == endpg) {
    	   startpg = pageNumber-3 < 1 ? 1 : pageNumber-3;
       } else {    
    	   startpg = pageNumber-2 < 1 ? 1 : pageNumber-2;
       }
       
       if(endpg == pageNumber) {
    	  endpg = pageNumber; 
       } else if (pageNumber == startpg) {
    	   endpg = pageNumber+3 > this.pages ? this.pages : pageNumber+3;       
       } else {    	  
    	   endpg = pageNumber+2 > this.pages ? this.pages : pageNumber+2;
       }
       
	   var pagerHtml = '<ul class="pagination"><li> <a href="#" id="pgfirst" onclick="' + this.pagerName + '.first();"> &#124&#8249 </a></li> ';
       pagerHtml += '<li> <a href="#" id="pgprev" onclick="' + this.pagerName + '.prev();"> &#171 </a></li> ';
       
       for (var page = startpg; page <= endpg; page++)
            pagerHtml += '<li><a href="#" id="pg' + page + '" onclick="' + this.pagerName + '.showPage(' + page + ');">' + page + '</a></li> ';
        
        pagerHtml += '<li><a href="#" id="pgnext" onclick="'+this.pagerName+'.next();">  &#187;</a></li>';
        pagerHtml += '<li><a href="#" id="pglast" onclick="'+this.pagerName+'.last();">  &#8250&#124</a></li></ul>';
        
        element.innerHTML = pagerHtml;
    };
}


