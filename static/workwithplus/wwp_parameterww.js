gx.evt.autoSkip=!1;gx.define("workwithplus.wwp_parameterww",!1,function(){var t,r,i,n,f,u;this.ServerClass="workwithplus.wwp_parameterww";this.PackageName="com";this.ServerFullClass="com.workwithplus.wwp_parameterww";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A5WWPParameterValue=gx.fn.getControlValue("WWPPARAMETERVALUE");this.AV29ManageFiltersExecutionStep=gx.fn.getIntegerValue("vMANAGEFILTERSEXECUTIONSTEP",".");this.AV47Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV16OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",".");this.AV17OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.A8WWPParameterDisableDelete=gx.fn.getControlValue("WWPPARAMETERDISABLEDELETE");this.AV14GridState=gx.fn.getControlValue("vGRIDSTATE")};this.s142_client=function(){this.DDO_GRIDContainer.SortedStatus=gx.text.trim(gx.num.str(this.AV16OrderedBy,4,0))+":"+(this.AV17OrderedDsc?"DSC":"ASC")};this.s162_client=function(){this.AV19FilterFullText=""};this.e120q2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e130q2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e140q2_client=function(){return this.executeServerEvent("DDO_GRID.ONOPTIONCLICKED",!1,null,!0,!0)};this.e110q2_client=function(){return this.executeServerEvent("DDO_MANAGEFILTERS.ONOPTIONCLICKED",!1,null,!0,!0)};this.e150q2_client=function(){return this.executeServerEvent("'DOINSERT'",!0,null,!1,!1)};this.e190q2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e200q2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,23,26,27,28,29,31,32,33,34,35,37,38,39,40,41,42,43,44,46,47,48];this.GXLastCtrlId=48;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",36,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"workwithplus.wwp_parameterww",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px","Nueva fila",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);r=this.GridContainer;r.addSingleLineEdit("Update",37,"vUPDATE","","Modificar","Update","char",0,"px",20,20,"start",null,[],"Update","Update",!0,0,!1,!1,"Attribute",0,"WWIconActionColumn");r.addSingleLineEdit("Delete",38,"vDELETE","","Eliminar","Delete","char",0,"px",20,20,"start",null,[],"Delete","Delete",!0,0,!1,!1,"",0,"WWIconActionColumn");r.addSingleLineEdit(4,39,"WWPPARAMETERKEY","Clave","","WWPParameterKey","svchar",0,"px",300,80,"start",null,[],4,"WWPParameterKey",!0,0,!1,!1,"Attribute",0,"WWColumn");r.addSingleLineEdit(6,40,"WWPPARAMETERCATEGORY","Categoría","","WWPParameterCategory","svchar",0,"px",200,80,"start",null,[],6,"WWPParameterCategory",!0,0,!1,!1,"Attribute",0,"WWColumn");r.addSingleLineEdit(7,41,"WWPPARAMETERDESCRIPTION","Descripción","","WWPParameterDescription","svchar",0,"px",200,80,"start",null,[],7,"WWPParameterDescription",!0,0,!1,!1,"Attribute",0,"WWColumn");r.addSingleLineEdit(9,42,"WWPPARAMETERVALUETRIMMED","Valor","","WWPParameterValueTrimmed","svchar",0,"px",30,30,"start",null,[],9,"WWPParameterValueTrimmed",!0,0,!1,!1,"Attribute",0,"WWColumn");this.GridContainer.emptyText="";this.setGrid(r);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,45,27,"DVelop_DVPaginationBar","GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");i=this.GRIDPAGINATIONBARContainer;i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Class","Class","PaginationBar","str");i.setProp("ShowFirst","Showfirst",!1,"bool");i.setProp("ShowPrevious","Showprevious",!0,"bool");i.setProp("ShowNext","Shownext",!0,"bool");i.setProp("ShowLast","Showlast",!1,"bool");i.setProp("PagesToShow","Pagestoshow",5,"num");i.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");i.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");i.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");i.setProp("SelectedPage","Selectedpage","","char");i.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");i.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");i.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");i.setProp("First","First","First","str");i.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");i.setProp("Next","Next","WWP_PagingNextCaption","str");i.setProp("Last","Last","Last","str");i.setProp("Caption","Caption","Página <CURRENT_PAGE> de <TOTAL_PAGES>","str");i.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");i.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");i.addV2CFunction("AV40GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");i.addC2VFunction(function(n){n.ParentObject.AV40GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV40GridCurrentPage)});i.addV2CFunction("AV41GridPageCount","vGRIDPAGECOUNT","SetPageCount");i.addC2VFunction(function(n){n.ParentObject.AV41GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV41GridPageCount)});i.setProp("RecordCount","Recordcount","","str");i.setProp("Page","Page","","str");i.addV2CFunction("AV8GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");i.addC2VFunction(function(n){n.ParentObject.AV8GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV8GridAppliedFilters)});i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});i.addEventHandler("ChangePage",this.e120q2_client);i.addEventHandler("ChangeRowsPerPage",this.e130q2_client);this.setUserControl(i);this.DDO_GRIDContainer=gx.uc.getNew(this,49,27,"DDOGridTitleSettingsM","DDO_GRIDContainer","Ddo_grid","DDO_GRID");n=this.DDO_GRIDContainer;n.setProp("Class","Class","","char");n.setProp("Enabled","Enabled",!0,"boolean");n.setProp("IconType","Icontype","Image","str");n.setProp("Icon","Icon","","str");n.setProp("Caption","Caption","","str");n.setProp("Tooltip","Tooltip","","str");n.setProp("Cls","Cls","","str");n.setProp("ActiveEventKey","Activeeventkey","","char");n.setProp("FilteredText_set","Filteredtext_set","","char");n.setProp("FilteredText_get","Filteredtext_get","","char");n.setProp("FilteredTextTo_set","Filteredtextto_set","","char");n.setProp("FilteredTextTo_get","Filteredtextto_get","","char");n.setProp("SelectedValue_set","Selectedvalue_set","","char");n.setProp("SelectedValue_get","Selectedvalue_get","","char");n.setProp("SelectedText_set","Selectedtext_set","","char");n.setProp("SelectedText_get","Selectedtext_get","","char");n.setProp("SelectedColumn","Selectedcolumn","","char");n.setProp("SelectedColumnFixedFilter","Selectedcolumnfixedfilter","","char");n.setProp("GAMOAuthToken","Gamoauthtoken","","char");n.setProp("TitleControlAlign","Titlecontrolalign","","str");n.setProp("Visible","Visible","","str");n.setDynProp("GridInternalName","Gridinternalname","","str");n.setProp("ColumnIds","Columnids","2:WWPParameterKey|3:WWPParameterCategory|4:WWPParameterDescription","str");n.setProp("ColumnsSortValues","Columnssortvalues","1|2|3","str");n.setProp("IncludeSortASC","Includesortasc","T","str");n.setProp("IncludeSortDSC","Includesortdsc","","str");n.setProp("AllowGroup","Allowgroup","","str");n.setProp("Fixable","Fixable","","str");n.setDynProp("SortedStatus","Sortedstatus","","char");n.setProp("IncludeFilter","Includefilter","","str");n.setProp("FilterType","Filtertype","","str");n.setProp("FilterIsRange","Filterisrange","","str");n.setProp("IncludeDataList","Includedatalist","","str");n.setProp("DataListType","Datalisttype","","str");n.setProp("AllowMultipleSelection","Allowmultipleselection","","str");n.setProp("DataListFixedValues","Datalistfixedvalues","","str");n.setProp("DataListProc","Datalistproc","","str");n.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");n.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");n.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");n.setProp("FixedFilters","Fixedfilters","","str");n.setProp("Format","Format","","str");n.setProp("SelectedFixedFilter","Selectedfixedfilter","","char");n.setProp("SortASC","Sortasc","","str");n.setProp("SortDSC","Sortdsc","","str");n.setProp("AllowGroupText","Allowgrouptext","","str");n.setProp("LoadingData","Loadingdata","","str");n.setProp("CleanFilter","Cleanfilter","","str");n.setProp("RangeFilterFrom","Rangefilterfrom","","str");n.setProp("RangeFilterTo","Rangefilterto","","str");n.setProp("NoResultsFound","Noresultsfound","","str");n.setProp("SearchButtonText","Searchbuttontext","","str");n.addV2CFunction("AV38DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");n.addC2VFunction(function(n){n.ParentObject.AV38DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV38DDO_TitleSettingsIcons)});n.setC2ShowFunction(function(n){n.show()});n.addEventHandler("OnOptionClicked",this.e140q2_client);this.setUserControl(n);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,50,27,"WWP_GridEmpowerer","GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");f=this.GRID_EMPOWERERContainer;f.setProp("Class","Class","","char");f.setProp("Enabled","Enabled",!0,"boolean");f.setDynProp("GridInternalName","Gridinternalname","","char");f.setProp("HasCategories","Hascategories",!1,"bool");f.setProp("InfiniteScrolling","Infinitescrolling","False","str");f.setProp("HasTitleSettings","Hastitlesettings",!0,"bool");f.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");f.setProp("HasRowGroups","Hasrowgroups",!1,"bool");f.setProp("FixedColumns","Fixedcolumns","","str");f.setProp("PopoversInGrid","Popoversingrid","","str");f.setProp("Visible","Visible",!0,"bool");f.setC2ShowFunction(function(n){n.show()});this.setUserControl(f);this.DDO_MANAGEFILTERSContainer=gx.uc.getNew(this,21,0,"BootstrapDropDownOptions","DDO_MANAGEFILTERSContainer","Ddo_managefilters","DDO_MANAGEFILTERS");u=this.DDO_MANAGEFILTERSContainer;u.setProp("Class","Class","","char");u.setProp("Enabled","Enabled",!0,"boolean");u.setProp("IconType","Icontype","FontIcon","str");u.setProp("Icon","Icon","fas fa-filter","str");u.setProp("Caption","Caption","","str");u.setProp("Tooltip","Tooltip","WWP_ManageFiltersTooltip","str");u.setProp("Cls","Cls","ManageFilters","str");u.setProp("ActiveEventKey","Activeeventkey","","char");u.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");u.setProp("DropDownOptionsType","Dropdownoptionstype","Regular","str");u.setProp("Visible","Visible",!0,"bool");u.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");u.addV2CFunction("AV27ManageFiltersData","vMANAGEFILTERSDATA","SetDropDownOptionsData");u.addC2VFunction(function(n){n.ParentObject.AV27ManageFiltersData=n.GetDropDownOptionsData();gx.fn.setControlValue("vMANAGEFILTERSDATA",n.ParentObject.AV27ManageFiltersData)});u.setProp("Gx Control Type","Gxcontroltype","","int");u.setC2ShowFunction(function(n){n.show()});u.addEventHandler("OnOptionClicked",this.e110q2_client);this.setUserControl(u);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLEMAIN",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TABLEHEADER",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"TABLEHEADERCONTENT",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"TABLEACTIONS",grid:0};t[14]={id:14,fld:"",grid:0};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"BTNINSERT",format:1,grid:0,evt:"e150q2_client",ctrltype:"textblock"};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"TABLERIGHTHEADER",grid:0};t[23]={id:23,fld:"TABLEFILTERS",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.GridContainer],fld:"vFILTERFULLTEXT",fmt:0,gxz:"ZV19FilterFullText",gxold:"OV19FilterFullText",gxvar:"AV19FilterFullText",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV19FilterFullText=n)},v2z:function(n){n!==undefined&&(gx.O.ZV19FilterFullText=n)},v2c:function(){gx.fn.setControlValue("vFILTERFULLTEXT",gx.O.AV19FilterFullText,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV19FilterFullText=this.val())},val:function(){return gx.fn.getControlValue("vFILTERFULLTEXT")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};t[34]={id:34,fld:"",grid:0};t[35]={id:35,fld:"",grid:0};t[37]={id:37,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:36,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUPDATE",fmt:1,gxz:"ZV45Update",gxold:"OV45Update",gxvar:"AV45Update",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV45Update=n)},v2z:function(n){n!==undefined&&(gx.O.ZV45Update=n)},v2c:function(n){gx.fn.setGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(36),gx.O.AV45Update,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV45Update=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(36))},nac:gx.falseFn};t[38]={id:38,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:36,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDELETE",fmt:1,gxz:"ZV46Delete",gxold:"OV46Delete",gxvar:"AV46Delete",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV46Delete=n)},v2z:function(n){n!==undefined&&(gx.O.ZV46Delete=n)},v2c:function(n){gx.fn.setGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(36),gx.O.AV46Delete,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV46Delete=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(36))},nac:gx.falseFn};t[39]={id:39,lvl:2,type:"svchar",len:300,dec:0,sign:!1,ro:1,isacc:0,grid:36,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"WWPPARAMETERKEY",fmt:0,gxz:"Z4WWPParameterKey",gxold:"O4WWPParameterKey",gxvar:"A4WWPParameterKey",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A4WWPParameterKey=n)},v2z:function(n){n!==undefined&&(gx.O.Z4WWPParameterKey=n)},v2c:function(n){gx.fn.setGridControlValue("WWPPARAMETERKEY",n||gx.fn.currentGridRowImpl(36),gx.O.A4WWPParameterKey,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A4WWPParameterKey=this.val(n))},val:function(n){return gx.fn.getGridControlValue("WWPPARAMETERKEY",n||gx.fn.currentGridRowImpl(36))},nac:gx.falseFn};t[40]={id:40,lvl:2,type:"svchar",len:200,dec:0,sign:!1,ro:1,isacc:0,grid:36,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"WWPPARAMETERCATEGORY",fmt:0,gxz:"Z6WWPParameterCategory",gxold:"O6WWPParameterCategory",gxvar:"A6WWPParameterCategory",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A6WWPParameterCategory=n)},v2z:function(n){n!==undefined&&(gx.O.Z6WWPParameterCategory=n)},v2c:function(n){gx.fn.setGridControlValue("WWPPARAMETERCATEGORY",n||gx.fn.currentGridRowImpl(36),gx.O.A6WWPParameterCategory,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A6WWPParameterCategory=this.val(n))},val:function(n){return gx.fn.getGridControlValue("WWPPARAMETERCATEGORY",n||gx.fn.currentGridRowImpl(36))},nac:gx.falseFn};t[41]={id:41,lvl:2,type:"svchar",len:200,dec:0,sign:!1,ro:1,isacc:0,grid:36,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"WWPPARAMETERDESCRIPTION",fmt:0,gxz:"Z7WWPParameterDescription",gxold:"O7WWPParameterDescription",gxvar:"A7WWPParameterDescription",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A7WWPParameterDescription=n)},v2z:function(n){n!==undefined&&(gx.O.Z7WWPParameterDescription=n)},v2c:function(n){gx.fn.setGridControlValue("WWPPARAMETERDESCRIPTION",n||gx.fn.currentGridRowImpl(36),gx.O.A7WWPParameterDescription,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A7WWPParameterDescription=this.val(n))},val:function(n){return gx.fn.getGridControlValue("WWPPARAMETERDESCRIPTION",n||gx.fn.currentGridRowImpl(36))},nac:gx.falseFn};t[42]={id:42,lvl:2,type:"svchar",len:30,dec:0,sign:!1,ro:1,isacc:0,grid:36,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"WWPPARAMETERVALUETRIMMED",fmt:0,gxz:"Z9WWPParameterValueTrimmed",gxold:"O9WWPParameterValueTrimmed",gxvar:"A9WWPParameterValueTrimmed",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A9WWPParameterValueTrimmed=n)},v2z:function(n){n!==undefined&&(gx.O.Z9WWPParameterValueTrimmed=n)},v2c:function(n){gx.fn.setGridControlValue("WWPPARAMETERVALUETRIMMED",n||gx.fn.currentGridRowImpl(36),gx.O.A9WWPParameterValueTrimmed,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A9WWPParameterValueTrimmed=this.val(n))},val:function(n){return gx.fn.getGridControlValue("WWPPARAMETERVALUETRIMMED",n||gx.fn.currentGridRowImpl(36))},nac:gx.falseFn};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"",grid:0};t[46]={id:46,fld:"",grid:0};t[47]={id:47,fld:"",grid:0};t[48]={id:48,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};this.AV19FilterFullText="";this.ZV19FilterFullText="";this.OV19FilterFullText="";this.ZV45Update="";this.OV45Update="";this.ZV46Delete="";this.OV46Delete="";this.Z4WWPParameterKey="";this.O4WWPParameterKey="";this.Z6WWPParameterCategory="";this.O6WWPParameterCategory="";this.Z7WWPParameterDescription="";this.O7WWPParameterDescription="";this.Z9WWPParameterValueTrimmed="";this.O9WWPParameterValueTrimmed="";this.AV27ManageFiltersData=[];this.AV19FilterFullText="";this.AV40GridCurrentPage=0;this.AV38DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.A8WWPParameterDisableDelete=!1;this.A5WWPParameterValue="";this.AV45Update="";this.AV46Delete="";this.A4WWPParameterKey="";this.A6WWPParameterCategory="";this.A7WWPParameterDescription="";this.A9WWPParameterValueTrimmed="";this.AV29ManageFiltersExecutionStep=0;this.AV47Pgmname="";this.AV16OrderedBy=0;this.AV17OrderedDsc=!1;this.AV14GridState={CurrentPage:0,OrderedBy:0,OrderedDsc:!1,HidingSearch:0,PageSize:"",CollapsedRecords:"",GroupBy:"",FilterValues:[],DynamicFilters:[]};this.Events={e120q2_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e130q2_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e140q2_client:["DDO_GRID.ONOPTIONCLICKED",!0],e110q2_client:["DDO_MANAGEFILTERS.ONOPTIONCLICKED",!0],e150q2_client:["'DOINSERT'",!0],e190q2_client:["ENTER",!0],e200q2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:"AV29ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{ctrl:"GRID",prop:"Rows"},{av:"AV19FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV47Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV16OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV17OrderedDsc",fld:"vORDEREDDSC",pic:""}],[{av:"AV29ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV40GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV41GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV8GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{av:"AV27ManageFiltersData",fld:"vMANAGEFILTERSDATA",pic:""},{av:"AV14GridState",fld:"vGRIDSTATE",pic:""}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV19FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV29ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV47Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV16OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV17OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV19FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV29ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV47Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV16OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV17OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["DDO_GRID.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV19FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV29ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV47Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV16OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV17OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_GRIDContainer.ActiveEventKey",ctrl:"DDO_GRID",prop:"ActiveEventKey"},{av:"this.DDO_GRIDContainer.SelectedValue_get",ctrl:"DDO_GRID",prop:"SelectedValue_get"}],[{av:"AV16OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV17OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"}]];this.EvtParms["GRID.LOAD"]=[[{av:"A4WWPParameterKey",fld:"WWPPARAMETERKEY",pic:"",hsh:!0},{av:"A8WWPParameterDisableDelete",fld:"WWPPARAMETERDISABLEDELETE",pic:""}],[{av:"AV45Update",fld:"vUPDATE",pic:""},{av:'gx.fn.getCtrlProperty("vUPDATE","Link")',ctrl:"vUPDATE",prop:"Link"},{av:"AV46Delete",fld:"vDELETE",pic:""},{av:'gx.fn.getCtrlProperty("vDELETE","Link")',ctrl:"vDELETE",prop:"Link"},{av:'gx.fn.getCtrlProperty("vDELETE","Class")',ctrl:"vDELETE",prop:"Class"}]];this.EvtParms["DDO_MANAGEFILTERS.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV19FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV29ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV47Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV16OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV17OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_MANAGEFILTERSContainer.ActiveEventKey",ctrl:"DDO_MANAGEFILTERS",prop:"ActiveEventKey"},{av:"AV14GridState",fld:"vGRIDSTATE",pic:""}],[{av:"AV29ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV14GridState",fld:"vGRIDSTATE",pic:""},{av:"AV16OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV17OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV19FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"},{av:"AV40GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV41GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV8GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{av:"AV27ManageFiltersData",fld:"vMANAGEFILTERSDATA",pic:""}]];this.EvtParms["'DOINSERT'"]=[[{av:"A4WWPParameterKey",fld:"WWPPARAMETERKEY",pic:"",hsh:!0}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("A5WWPParameterValue","WWPPARAMETERVALUE",0,"vchar",2097152,0);this.setVCMap("AV29ManageFiltersExecutionStep","vMANAGEFILTERSEXECUTIONSTEP",0,"int",1,0);this.setVCMap("AV47Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV16OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV17OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("A8WWPParameterDisableDelete","WWPPARAMETERDISABLEDELETE",0,"boolean",4,0);this.setVCMap("AV14GridState","vGRIDSTATE",0,"WWPBaseObjectsWWPGridState",0,0);this.setVCMap("AV29ManageFiltersExecutionStep","vMANAGEFILTERSEXECUTIONSTEP",0,"int",1,0);this.setVCMap("AV47Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV16OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV17OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV29ManageFiltersExecutionStep","vMANAGEFILTERSEXECUTIONSTEP",0,"int",1,0);this.setVCMap("AV47Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV16OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV17OrderedDsc","vORDEREDDSC",0,"boolean",4,0);r.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});r.addRefreshingVar(this.GXValidFnc[27]);r.addRefreshingVar({rfrVar:"AV29ManageFiltersExecutionStep"});r.addRefreshingVar({rfrVar:"AV47Pgmname"});r.addRefreshingVar({rfrVar:"AV16OrderedBy"});r.addRefreshingVar({rfrVar:"AV17OrderedDsc"});r.addRefreshingParm(this.GXValidFnc[27]);r.addRefreshingParm({rfrVar:"AV29ManageFiltersExecutionStep"});r.addRefreshingParm({rfrVar:"AV47Pgmname"});r.addRefreshingParm({rfrVar:"AV16OrderedBy"});r.addRefreshingParm({rfrVar:"AV17OrderedDsc"});this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState",{FilterValues:{sdt:"WWPBaseObjects\\WWPGridState.FilterValue"},DynamicFilters:{sdt:"WWPBaseObjects\\WWPGridState.DynamicFilter"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState.DynamicFilter",{Dsc:{extr:"d"}})});gx.wi(function(){gx.createParentObj(this.workwithplus.wwp_parameterww)})