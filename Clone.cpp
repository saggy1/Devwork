#include <iostream>
using namespace std;

struct point{
int z;
int y;
};

class Shape{
public:
	Point start;
	Point end;
	//int ShapeType=1;
	
public:
virtual void draw()=0;
virtual Shape *clone=0;
};
class Line:public Shape{
public:
Line(){
////int ShapeType=1;
void draw() override{
cout<< "Line" << endl;
}
Shape *clone() override{
return new Line();
}

};

class Rectangle : public Shape {
public:
Rectangle(){
//ShapeType=2;
}
void draw override(){
cout<<"Rectangle"<<endl;
}
Shape *clone() override{
return new Rectangle();
}
};

Class Eclipse: public Shape{
public:
Eclipse(){
//ShapeType =3
}
void draw override(){
cout<<"Eclipse"<<endl;
}
Eclipse *clone() override(){
return new Eclipse();
}
};
Shape *menuSelection(){
	return new Eclipse();
}
int main(){
	Shape *Shape= menuSelection();
	shape -> draw;
	Shape *newShape;
	newShape = shape->clone();
	newShape->draw();
}