#include <stdio.h>
#include <iostream>
using namespace std;

struct Node
{
    char data;
    struct Node *lptr;
    struct Node *rptr;
};

struct Node *create()
{
    struct Node *p = (struct Node*)(malloc(sizeof(struct Node *)));
    char x;
    cout<<"ENTER Node Data: ";
    cin>>x;
    if(x=='n')
    {
        return NULL;
    }
    else
    {
        p -> data = x; 
        p -> lptr = create();
        p -> rptr = create();
        return p;
    }
}

void preorder(struct Node *t)
{
    if(t!=NULL)
    {
        printf("%c",t->data);
        preorder(t->lptr);
        preorder(t->rptr);
    }
}

int main()
{
    struct Node *root;
    root = create();
    preorder(root);
}