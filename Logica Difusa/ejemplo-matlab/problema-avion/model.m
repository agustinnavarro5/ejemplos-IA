% Un avi�n est� sujeto a turbulencias, las que cuasan que el avi�n
% baje y suba bruscamente formando un �ngulo respecto  a su
% l�nea de vuelo. Se desea un sistema de control difuso
% para que un piloto autom�tico responda al problema 
% de turbulencias ajustando la posici�n del tim�n de la aeronave.

fuzzyLogicDesigner('pavion_model');
fprintf('Presione Enter para continuar \n');
pause;

out = readfis('pavion_model');
result = evalfis([3 7], out);

fprintf('Resultado \n');
disp(result);