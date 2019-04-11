<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script src="https://cdn.jotfor.ms/static/prototype.forms.js" type="text/javascript"></script>
<script src="https://cdn.jotfor.ms/static/jotform.forms.js?3.3.10589" type="text/javascript"></script>
<script src="https://js.jotform.com/vendor/postMessage.js?3.3.10589" type="text/javascript"></script>
<script src="https://js.jotform.com/WidgetsServer.js?v=1553836442717" type="text/javascript"></script>
<script type="text/javascript">
	JotForm.init(function(){
      JotForm.alterTexts(undefined);
	JotForm.clearFieldOnHide="disable";
	JotForm.submitError="jumpToFirstError";
    /*INIT-END*/
	});

   JotForm.prepareCalculationsOnTheFly([null,{"name":"selectAppointment","qid":"1","text":"Select Appointment Date","type":"control_head"},{"name":"selectSlot","qid":"2","text":"Select Slot","type":"control_button"},{"name":"typeA","qid":"3","text":"Date Reservation","type":"control_widget"}]);
   setTimeout(function() {
JotForm.paymentExtrasOnTheFly([null,{"name":"selectAppointment","qid":"1","text":"Select Appointment Date","type":"control_head"},{"name":"selectSlot","qid":"2","text":"Select Slot","type":"control_button"},{"name":"typeA","qid":"3","text":"Date Reservation","type":"control_widget"}]);}, 20); 
</script>
<link href="https://cdn.jotfor.ms/static/formCss.css?3.3.10589" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="https://cdn.jotfor.ms/css/styles/nova.css?3.3.10589" />
<link type="text/css" media="print" rel="stylesheet" href="https://cdn.jotfor.ms/css/printForm.css?3.3.10589" />
<link type="text/css" rel="stylesheet" href="https://cdn.jotfor.ms/themes/CSS/566a91c2977cdfcd478b4567.css?"/>
<style type="text/css">
    .form-label-left{
        width:150px;
    }
    .form-line{
        padding-top:12px;
        padding-bottom:12px;
    }
    .form-label-right{
        width:150px;
    }
    .form-all{
        width:690px;
        color:#555 !important;
        font-family:"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", Verdana, sans-serif;
        font-size:14px;
    }
</style>

<style type="text/css" id="form-designer-style">
    /* Injected CSS Code */
.form-label.form-label-auto { display: block; float: none; text-align: left; width: inherit; } /*__INSPECT_SEPERATOR__*/
    /* Injected CSS Code */
</style>

<form class="jotform-form" action="#" method="post" name="form_90870876098473" id="90870876098473" accept-charset="utf-8">
  <input type="hidden" name="formID" value="90870876098473" />
  <div class="form-all">
    <ul class="form-section page-section">
      <li id="cid_1" class="form-input-wide" data-type="control_head">
        <div class="form-header-group ">
          <div class="header-text httal htvam">
            <h2 id="header_1" class="form-header" data-component="header">
              Select Appointment Date
            </h2>
          </div>
        </div>
      </li>
      <li class="form-line" data-type="control_widget" id="id_3">
        <label class="form-label form-label-top form-label-auto" id="label_3" for="input_3"> Date Reservation </label>
        <div id="cid_3" class="form-input-wide">
          <div style="width:100%;text-align:Left" data-component="widget-field">
            <iframe frameBorder="0" scrolling="no" allowtransparency="true" allow="geolocation; microphone; camera; autoplay; encrypted-media; fullscreen" data-type="iframe" class="custom-field-frame" id="customFieldFrame_3" src="" style="border:none;width:280px;height:280px" data-width="280" data-height="280">
            </iframe>
            <div class="widget-inputs-wrapper">
              <input type="text" id="input_3" class="form-hidden form-widget  " name="q3_typeA" value="" />
              <input type="hidden" id="widget_settings_3" class="form-hidden form-widget-settings" value="%5B%7B%22name%22%3A%22limit%22%2C%22value%22%3A%221%22%7D%2C%7B%22name%22%3A%22allowPastDates%22%2C%22value%22%3A%22no%22%7D%2C%7B%22name%22%3A%22allowWeekends%22%2C%22value%22%3A%22yes%22%7D%2C%7B%22name%22%3A%22dateFormat%22%2C%22value%22%3A%22yy-mm-dd%22%7D%2C%7B%22name%22%3A%22apiKey%22%2C%22value%22%3A%22encoded%3AuQrHcvdV603EFR%2Bu9TtKEnD0MIhiOzJVOZlOSt%2BMinQ%3D%22%7D%2C%7B%22name%22%3A%22allowToday%22%2C%22value%22%3A%22yes%22%7D%5D" data-version="2" />
            </div>
            <script type="text/javascript">
            setTimeout(function()
{
  var _cFieldFrame = document.getElementById("customFieldFrame_3");
  if (_cFieldFrame)
  {
    _cFieldFrame.onload = function()
    {
      if (typeof widgetFrameLoaded !== 'undefined')
      {
        widgetFrameLoaded(3, {
          "formID": 90870876098473
        })
      }
    };
    _cFieldFrame.src = "//data-widgets.jotform.io/dateReservation/?qid=3&ref=" + encodeURIComponent(window.location.protocol + "//" + window.location.host);
    _cFieldFrame.addClassName("custom-field-frame-rendered");
  }
}, 0);
            </script>
          </div>
        </div>
      </li>
      <li class="form-line" data-type="control_button" id="id_2">
        <div id="cid_2" class="form-input-wide">
          <div style="margin-left:156px" class="form-buttons-wrapper">
            <button id="input_2" type="submit" class="form-submit-button" data-component="button">
              Select Slot
            </button>
          </div>
        </div>
      </li>
      <li style="display:none">
        Should be Empty:
        <input type="text" name="website" value="" />
      </li>
    </ul>
  </div>
  
 
 
  
  
</form>
