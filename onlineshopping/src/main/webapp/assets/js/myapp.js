$(function() {

	// Solving the active menu problem
	switch (menu) {
	
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#allProducts').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}
})

//jQuery Datatable format

var $table=$('#productListTable');

if($table.length)
	{
		var jsonUrl=''; 
		if(categoryId=='')
			{
				jsonUrl=window.contextRoot+'/json/data/all/products';
			}
		else
			{
				jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
			}
		//console.log('Inside table');
		$table.DataTable({
			
			lengthMenu:[[3,5,10,-1],['3','5','10','All']],
			ajax : {
				
				url:jsonUrl,
				dataSrc:'',
			},
			
			columns:[
			         
			         {
			        	 data:'name',
			         },
			         {
			        	 data:'brand',
			         },
			         {
			        	 date:'unitPrice',
			         },
			         {
			        	 data:'quantity',
			         },
			         
			         
			         ]
			
			
		});
	}