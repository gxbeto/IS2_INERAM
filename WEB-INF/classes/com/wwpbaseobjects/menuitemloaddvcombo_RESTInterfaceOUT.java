package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "wwpbaseobjects.menuitemloaddvcombo_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class menuitemloaddvcombo_RESTInterfaceOUT
{
   String AV21SelectedValue;
   @JsonProperty("SelectedValue")
   public String getSelectedValue( )
   {
      return AV21SelectedValue ;
   }

   @JsonProperty("SelectedValue")
   public void setSelectedValue(  String Value )
   {
      AV21SelectedValue= Value;
   }


   String AV22SelectedText;
   @JsonProperty("SelectedText")
   public String getSelectedText( )
   {
      return AV22SelectedText ;
   }

   @JsonProperty("SelectedText")
   public void setSelectedText(  String Value )
   {
      AV22SelectedText= Value;
   }


   String AV23Combo_DataJson;
   @JsonProperty("Combo_DataJson")
   public String getCombo_DataJson( )
   {
      return AV23Combo_DataJson ;
   }

   @JsonProperty("Combo_DataJson")
   public void setCombo_DataJson(  String Value )
   {
      AV23Combo_DataJson= Value;
   }


}

