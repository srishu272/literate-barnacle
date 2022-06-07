#include<stdio.h>
#include<iostream>
using namespace std;

struct Node
{
    int data;
    struct Node *lptr;
    struct Node *rptr;
};

struct Node *newNode(int value)
{
    struct Node *temp = (struct Node *)(malloc(sizeof(struct Node *)));
    temp->data = value;
    temp->lptr=temp->rptr=NULL;
    return temp;
}

struct Node* insert(struct Node* node, int value)
{
    if(node == NULL)
    return newNode(value);

    if (value < node->data)
    {
        node->lptr = insert(node->lptr,value);
    }

    if(value > node->data)
    {
        node->rptr = insert(node->rptr,value);
    }
    return node;
    
}

struct Node*search(struct Node *root,int value)
{
    if((root == NULL)||(root->data == value))
    {
        return root;
    }
    if (root->data < value)
    {
        return search(root->rptr,value);
    }
    if (root->data > value)
    {
        return search(root->lptr,value);
    }
}
    

void inorder(struct Node *t)
{
    if(t!=NULL)
    {
        inorder(t->lptr);
        printf(" %d ",t->data);
        inorder(t->rptr);
    }
}

int main()
{
    struct Node *root = NULL; 
    int choice;
    char c;
    do
    {
        cout<<"1. Inserting Node\n2.Inorder Traversal\n3.Search Node\n4. Exit\n";
        int num,s;
        cin>>choice;
        
        switch (choice)
        {
        case 1:
            cout<<"Enter data: ";
            cin>>num;
            root = insert(root,num);
            break;

        case 2:
            inorder(root);
            break;
        
        case 3:
            cout<<"Enter the number to search: ";
            cin>>s;
            root = search(root,s);
            cout<<root;
            break;

        case 4:
            exit;

        default:
            cout<<"Invalid choice";
            break;
        }
       cout<<"----------------------------------------------------------------------\n";
       cout<<"Do you want to continue: ";
       fflush(stdin);
       cin>>c;
    } while ((c=='Y')||(c=='y'));
    
}